package com.DDD.Logistic.worker.values;

import co.com.sofka.domain.generic.Identity;
import com.DDD.Logistic.system.values.WorkerId;

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
