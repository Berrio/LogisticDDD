package com.DDD.Logistic.system.values;

import co.com.sofka.domain.generic.Identity;

public class ObservationId extends Identity {
    public ObservationId() {
    }

    private ObservationId(String id) {
        super(id);
    }

    public static ObservationId of(String id) {
        return new ObservationId(id);
    }
}
