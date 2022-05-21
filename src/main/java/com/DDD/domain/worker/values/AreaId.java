package com.DDD.domain.worker.values;

import co.com.sofka.domain.generic.Identity;

public class AreaId extends Identity {
    public AreaId() {
    }

    private AreaId(String id) {
        super(id);
    }



    public static AreaId of(String id) {
        return new AreaId(id);
    }
}
