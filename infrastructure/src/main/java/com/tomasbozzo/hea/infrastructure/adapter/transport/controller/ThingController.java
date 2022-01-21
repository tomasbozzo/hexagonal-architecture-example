package com.tomasbozzo.hea.infrastructure.adapter.transport.controller;

import com.tomasbozzo.hea.application.usecase.CreateThingUseCase;
import com.tomasbozzo.hea.application.usecase.GetAllThingsUseCase;
import com.tomasbozzo.hea.application.usecase.GetThingUseCase;
import com.tomasbozzo.hea.domain.model.Thing;
import com.tomasbozzo.hea.domain.model.ThingId;
import com.tomasbozzo.hea.infrastructure.adapter.transport.controller.exception.ApiException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequiredArgsConstructor
public class ThingController {

    private final CreateThingUseCase createThingUseCase;
    private final GetThingUseCase getThingUseCase;
    private final GetAllThingsUseCase getAllThingsUseCase;

    @PostMapping("/things")
    @ResponseBody
    ResponseEntity<ThingPostResponseDto> postThing() {
        return ok(toThingDto(createThingUseCase.execute()));
    }

    @GetMapping("/things/{id}")
    ResponseEntity<ThingDto> getThing(@PathVariable String id) {
        return getThingUseCase.execute(new GetThingUseCase.Request(new ThingId(id)))
                .map(this::toThingDtoResponse)
                .orElseThrow(() -> new ApiException("The thing was not found", NOT_FOUND));
    }

    @GetMapping("/things")
    ResponseEntity<List<ThingDto>> getThings() {
        List<ThingDto> things = getAllThingsUseCase.execute().stream()
                .map(this::toThingDto)
                .collect(Collectors.toList());

        return ok(things);
    }

    private ThingDto toThingDto(Thing thing) {
        ThingDto thingDto = new ThingDto();

        thingDto.setId(thing.getId().getValue());
        thingDto.setName(thing.getName());

        return thingDto;
    }

    private ResponseEntity<ThingDto> toThingDtoResponse(Thing thing) {
        ThingDto thingDto = new ThingDto();

        thingDto.setId(thing.getId().getValue());
        thingDto.setName(thing.getName());

        return ok(thingDto);
    }

    private ThingPostResponseDto toThingDto(CreateThingUseCase.Response response) {
        ThingPostResponseDto thingDto = new ThingPostResponseDto();
        thingDto.setId(response.getThingId().getValue());

        return thingDto;
    }
}
