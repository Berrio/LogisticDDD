package com.DDD.domain.system.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.DDD.domain.system.values.Description;
import com.DDD.domain.system.values.ObservationId;

public class ObservationAdded extends DomainEvent {

    private final ObservationId observationId;
    private final Description description;


    public ObservationAdded(ObservationId observationId, Description description) {
        super("logistic.system.observationadded");
        this.observationId = observationId;
        this.description = description;
    }

    public Description getDescription() {
        return description;
    }

    public ObservationId getObservationId() {
        return observationId;
    }
}
