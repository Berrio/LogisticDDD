package com.DDD.Logistic.system;

import co.com.sofka.domain.generic.AggregateEvent;
import com.DDD.Logistic.system.values.SystemId;
import com.DDD.Logistic.system.values.SystemName;
import com.DDD.Logistic.system.values.WorkerId;

import java.util.Set;

public class System extends AggregateEvent<SystemId> {

    protected WorkerId workerId;
    protected SystemName systemName;
    protected Set<Observation> observations;
    protected Set<Product>products;
    protected Set<Position>positions;

    public System(SystemId entityId) {
        super(entityId);
    }
}
