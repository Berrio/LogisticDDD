package com.DDD.domain.system.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.DDD.domain.system.values.Description;
import com.DDD.domain.system.values.ObservationId;

public class DescriptionUpdated extends DomainEvent {

    private final ObservationId observationId;
    private final Description description;

    public DescriptionUpdated(ObservationId observationId, Description description) {
        super("logistic.system.descriptionupdated");
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
