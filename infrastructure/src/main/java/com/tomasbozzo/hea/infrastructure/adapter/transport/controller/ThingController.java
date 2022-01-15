package com.tomasbozzo.hea.infrastructure.adapter.transport.controller;

import com.tomasbozzo.hea.application.usecase.CreateThingUseCase;
import com.tomasbozzo.hea.application.usecase.GetThingUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import static org.springframework.http.ResponseEntity.internalServerError;
import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequiredArgsConstructor
public class ThingController {

    private final CreateThingUseCase createThingUseCase;
    private final GetThingUseCase getThingUseCase;

    @PostMapping("/things")
    @ResponseBody
    Mono<ResponseEntity<ThingDto>> postThing() {
        return createThingUseCase.execute()
                .map(response -> ok(toThingDto(response)));
    }

    @GetMapping("/things/{id}")
    Mono<ResponseEntity<ThingDto>> getThing(@PathVariable String id) {
        return getThingUseCase.execute(new GetThingUseCase.Request(id))
                .map(this::toThingDtoResponse)
                .switchIfEmpty(notFound());
    }

    private ResponseEntity<ThingDto> toThingDtoResponse(GetThingUseCase.Response response) {
        ThingDto thingDto = new ThingDto();

        thingDto.setId(response.thing().getId().getValue());
        thingDto.setName(response.thing().getName());

        return ok(thingDto);
    }

    private ThingDto toThingDto(CreateThingUseCase.Response response) {
        ThingDto thingDto = new ThingDto();
        thingDto.setId(response.getThingId().getValue());

        return thingDto;
    }

    private <T> Mono<ResponseEntity<T>> notFound() {
        return Mono.just(ResponseEntity.notFound().build());
    }
}
