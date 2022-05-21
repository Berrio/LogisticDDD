package com.DDD.Logistic.system.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.DDD.Logistic.system.values.Description;
import com.DDD.Logistic.system.values.ObservationId;

public class DescriptionUpdated extends DomainEvent {

    private final Description description;
    public DescriptionUpdated(ObservationId observationId, Description description) {
        super("logistic.system.descriptionupdated");
        this.description=description;
    }

    public Description getDescription() {
        return description;
    }
}
