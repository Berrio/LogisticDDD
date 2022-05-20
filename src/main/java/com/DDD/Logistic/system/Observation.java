package com.DDD.Logistic.system;

import co.com.sofka.domain.generic.Entity;
import com.DDD.Logistic.system.values.Description;
import com.DDD.Logistic.system.values.ObservationId;
import com.DDD.Logistic.system.values.PositionId;
import com.DDD.Logistic.system.values.Stowage;

import java.util.Objects;

public class Observation extends Entity<ObservationId> {

    private  Description description;

    public Observation(ObservationId observationId,Description description) {
        super(observationId);
        this.description=description;
    }

    public void updateStowage(Description description){
        this.description= Objects.requireNonNull(description);
    }

    public Description description() {
        return description;
    }
}
