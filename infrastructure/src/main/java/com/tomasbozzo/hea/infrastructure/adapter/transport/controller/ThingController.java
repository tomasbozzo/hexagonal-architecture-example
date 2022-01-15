package com.tomasbozzo.hea.infrastructure.adapter.transport.controller;

import com.tomasbozzo.hea.application.usecase.CreateThingUseCase;
import com.tomasbozzo.hea.application.usecase.GetAllThingsUseCase;
import com.tomasbozzo.hea.application.usecase.GetThingUseCase;
import com.tomasbozzo.hea.domain.model.Thing;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequiredArgsConstructor
public class ThingController {

    private final CreateThingUseCase createThingUseCase;
    private final GetThingUseCase getThingUseCase;
    private final GetAllThingsUseCase getAllThingsUseCase;

    @PostMapping("/things")
    @ResponseBody
    Mono<ResponseEntity<ThingPostResponseDto>> postThing() {
        return createThingUseCase.execute()
                .map(response -> ok(toThingDto(response)));
    }

    @GetMapping("/things/{id}")
    Mono<ResponseEntity<ThingDto>> getThing(@PathVariable String id) {
        return getThingUseCase.execute(new GetThingUseCase.Request(id))
                .map(this::toThingDtoResponse)
                .switchIfEmpty(notFound());
    }

    @GetMapping("/things")
    Flux<ThingDto> getThings() {
        return getAllThingsUseCase.execute().things()
                .map(this::toThingDto);
    }

    private ThingDto toThingDto(Thing thing) {
        ThingDto thingDto = new ThingDto();

        thingDto.setId(thing.getId().getValue());
        thingDto.setName(thing.getName());

        return thingDto;
    }

    private ResponseEntity<ThingDto> toThingDtoResponse(GetThingUseCase.Response response) {
        ThingDto thingDto = new ThingDto();

        thingDto.setId(response.thing().getId().getValue());
        thingDto.setName(response.thing().getName());

        return ok(thingDto);
    }

    private ThingPostResponseDto toThingDto(CreateThingUseCase.Response response) {
        ThingPostResponseDto thingDto = new ThingPostResponseDto();
        thingDto.setId(response.getThingId().getValue());

        return thingDto;
    }

    private <T> Mono<ResponseEntity<T>> notFound() {
        return Mono.just(ResponseEntity.notFound().build());
    }
}
