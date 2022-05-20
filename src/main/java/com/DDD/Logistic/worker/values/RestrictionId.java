package com.DDD.Logistic.worker.values;

import co.com.sofka.domain.generic.Identity;

public class RestrictionId extends Identity {
    public RestrictionId() {
    }

    private RestrictionId(String id) {
        super(id);
    }

    public static RestrictionId of(String id) {
        return new RestrictionId(id);
    }
}
