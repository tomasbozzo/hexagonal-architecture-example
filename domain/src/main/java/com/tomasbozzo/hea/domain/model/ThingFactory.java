package com.tomasbozzo.hea.domain.model;

import java.util.ArrayList;
import java.util.List;

public class ThingFactory {
    public static Thing createEmptyThing() {
        return new Thing(new ThingId(), "an empty thing", new ArrayList<>());
    }

    public static Thing createThing(ThingId thingId, String thingName, List<SubThing> subThings) {
        return new Thing(thingId, thingName, subThings);
    }
}
