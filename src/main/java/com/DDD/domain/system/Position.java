package com.DDD.domain.system;

import co.com.sofka.domain.generic.Entity;
import com.DDD.domain.system.values.PositionId;
import com.DDD.domain.system.values.Stowage;

import java.util.Objects;

public class Position extends Entity<PositionId> {

    private Stowage stowage;

    public Position(PositionId positionId, Stowage stowage) {
        super(positionId);
        this.stowage = stowage;
    }

    public void updateStowage(Stowage stowage) {
        this.stowage = Objects.requireNonNull(stowage);
    }

    public Stowage stowage() {
        return stowage;
    }
}
