package com.DDD.domain.system.values;

import co.com.sofka.domain.generic.Identity;

public class PositionId extends Identity {
    public PositionId() {
    }

    private PositionId(String id) {
        super(id);
    }

    public static PositionId of(String id) {
        return new PositionId(id);
    }
}
