package com.DDD.Logistic.system.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.DDD.Logistic.system.values.Description;
import com.DDD.Logistic.system.values.ObservationId;

public class descriptionUpdated extends DomainEvent {
    public descriptionUpdated(ObservationId observationId, Description description) {
        super();
    }
}
