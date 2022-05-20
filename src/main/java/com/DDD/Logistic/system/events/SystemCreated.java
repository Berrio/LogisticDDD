package com.DDD.Logistic.system.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.DDD.Logistic.system.Observation;
import com.DDD.Logistic.system.Position;
import com.DDD.Logistic.system.Product;
import com.DDD.Logistic.system.values.SystemName;
import com.DDD.Logistic.system.values.WorkerId;

import java.util.Set;
import java.util.UUID;

public class SystemCreated extends DomainEvent {

    protected WorkerId workerId;
    protected SystemName systemName;
    protected Set<Position> positions;
    protected Set<Product>products;
    protected Set<Observation>Observations;

    public SystemCreated(SystemName systemName,WorkerId workerId,Set<Position> positions,Set<Product>products,Set<Observation>observations) {
        super("logisctic.system.systemcreated");
        this.workerId=workerId;
        this.systemName=systemName;
        this.positions=positions;
        this.products=products;
        this.Observations=observations;

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
