package com.DDD.Logistic.system.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.DDD.Logistic.system.values.PositionId;
import com.DDD.Logistic.system.values.Stowage;

public class PositionStowageUpdated extends DomainEvent {
    public PositionStowageUpdated(PositionId positionId, Stowage stowage) {
        super();
    }
}
