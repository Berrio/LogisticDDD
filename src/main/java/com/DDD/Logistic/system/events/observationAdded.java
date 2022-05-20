package com.DDD.Logistic.system.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.DDD.Logistic.system.values.Description;
import com.DDD.Logistic.system.values.ObservationId;

public class observationAdded extends DomainEvent {
    private final Description description;
    public observationAdded(ObservationId observationId, Description description) {
        super("logistic.system.observationadded");
        this.description=description;
    }

    public Description getDescription() {
        return description;
    }
}
