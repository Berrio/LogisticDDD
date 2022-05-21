package com.DDD.domain.system.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.DDD.domain.system.values.PositionId;
import com.DDD.domain.system.values.Stowage;

public class PositionStowageUpdated extends DomainEvent {

    private final PositionId positionId;
    private final Stowage stowage;

    public PositionStowageUpdated(PositionId positionId, Stowage stowage) {
        super("logistic.system.positionstowageupdated");
        this.positionId = positionId;
        this.stowage = stowage;
    }

    public Stowage getStowage() {
        return stowage;
    }

    public PositionId getPositionId() {
        return positionId;
    }
}
