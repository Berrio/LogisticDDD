package com.DDD.Logistic.system.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.DDD.Logistic.system.values.PositionId;
import com.DDD.Logistic.system.values.Stowage;

public class PositionAdded extends DomainEvent {

    private final PositionId positionId;
    private final Stowage stowage;

    public PositionAdded(PositionId positionId, Stowage stowage) {
        super("logistic.system.positionadded");
        this.stowage=stowage;
        this.positionId=positionId;
    }

    public Stowage getStowage() {
        return stowage;
    }

    public PositionId getPositionId() {
        return positionId;
    }
}
