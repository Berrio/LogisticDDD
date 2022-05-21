package com.DDD.domain.system.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.DDD.domain.system.Observation;
import com.DDD.domain.system.Position;
import com.DDD.domain.system.Product;
import com.DDD.domain.system.values.SystemName;
import com.DDD.domain.system.values.WorkerId;

import java.util.Set;

public class SystemCreate extends DomainEvent {

    protected WorkerId workerId;
    protected SystemName systemName;
    protected Set<Position> positions;
    protected Set<Product> products;
    protected Set<Observation> Observations;

    public SystemCreate(SystemName systemName) {
        super("logisctic.system.systemcreated");
        this.systemName = systemName;
    }

    public WorkerId workerId() {
        return workerId;
    }

    public SystemName getSystemName() {
        return systemName;
    }

    public Set<Position> getPositions() {
        return positions;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public Set<Observation> getObservations() {
        return Observations;
    }
}
