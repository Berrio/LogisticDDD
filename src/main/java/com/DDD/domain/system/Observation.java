package com.DDD.domain.system;

import co.com.sofka.domain.generic.Entity;
import com.DDD.domain.system.values.Description;
import com.DDD.domain.system.values.ObservationId;

import java.util.Objects;

public class Observation extends Entity<ObservationId> {

    private Description description;

    public Observation(ObservationId observationId, Description description) {
        super(observationId);
        this.description = description;
    }

    public void updateDesciption(Description description) {
        this.description = Objects.requireNonNull(description);
    }

    public Description description() {
        return description;
    }
}
