package com.tomasbozzo.hea.domain.model;

import java.util.ArrayList;

public class ThingFactory {
    public static Thing createEmptyThing() {
        return new Thing(new ThingId(), "an empty thing", new ArrayList<>());
    }
}
