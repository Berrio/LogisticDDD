package com.DDD.Logistic.system.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.DDD.Logistic.system.values.Description;
import com.DDD.Logistic.system.values.PositionId;
import com.DDD.Logistic.system.values.Stowage;

public class PositionStowageUpdated extends DomainEvent {

    private final Stowage stowage;

    public PositionStowageUpdated(PositionId positionId, Stowage stowage) {
        super("logistic.system.positionstowageupdated");
        this.stowage=stowage;
    }

    public Stowage getStowage() {
        return stowage;
    }
}
