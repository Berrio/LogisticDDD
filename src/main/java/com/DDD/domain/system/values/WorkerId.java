package com.DDD.domain.system.values;

import co.com.sofka.domain.generic.Identity;

public class WorkerId extends Identity {
    public WorkerId() {
    }

    private WorkerId(String id) {
        super(id);
    }

    public static WorkerId of(String id) {
        return new WorkerId(id);
    }
}
