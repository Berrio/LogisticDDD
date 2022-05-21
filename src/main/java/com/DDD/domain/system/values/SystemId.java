package com.DDD.domain.system.values;

import co.com.sofka.domain.generic.Identity;

public class SystemId extends Identity {
    public SystemId() {
    }

    private SystemId(String id) {
        super(id);
    }

    public static SystemId of(String id) {
        return new SystemId(id);
    }
}
