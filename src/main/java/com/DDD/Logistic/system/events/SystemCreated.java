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

    protected WorkerId typeID;
    protected SystemName systemName;
    protected Set<Position> positions;
    protected Set<Product>products;
    protected Set<Observation>Observations;

    public SystemCreated(SystemName systemName,WorkerId typeID,Set<Position> positions,Set<Product>products,Set<Observation>Observations) {
        super("logisctic.system.systemcreated");
        this.typeID=typeID;
        this.systemName=systemName;
        this.positions=positions;
        this.products=products;
        this.Observations=Observations;

    }

    public WorkerId getTypeID() {
        return typeID;
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
