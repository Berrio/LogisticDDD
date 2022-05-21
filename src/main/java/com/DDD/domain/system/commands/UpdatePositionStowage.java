package com.DDD.domain.system.commands;

import co.com.sofka.domain.generic.Command;
import com.DDD.domain.system.values.PositionId;
import com.DDD.domain.system.values.Stowage;
import com.DDD.domain.system.values.SystemId;

public class UpdatePositionStowage extends Command {

    private final SystemId systemId;
    private final PositionId positionId;
    private final Stowage stowage;

    public UpdatePositionStowage(SystemId systemId, PositionId positionId, Stowage stowage) {
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
