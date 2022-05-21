package com.DDD.Logistic.system.commands;

import co.com.sofka.domain.generic.Command;
import com.DDD.Logistic.system.values.PositionId;
import com.DDD.Logistic.system.values.Stowage;
import com.DDD.Logistic.system.values.SystemId;

public class AddPosition extends Command {

    private final SystemId systemId;
    private final PositionId positionId;
    private final Stowage stowage;

    public AddPosition(SystemId systemId, PositionId positionId, Stowage stowage) {
        this.systemId = systemId;
        this.positionId = positionId;
        this.stowage = stowage;
    }

    public SystemId getSystemId() {
        return systemId;
    }

    public PositionId getPositionId() {
        return positionId;
    }

    public Stowage getStowage() {
        return stowage;
    }
}
