package com.DDD.Logistic.system;

import co.com.sofka.domain.generic.AggregateEvent;
import com.DDD.Logistic.system.events.*;
import com.DDD.Logistic.system.values.*;

import java.util.Objects;
import java.util.Set;

public class System extends AggregateEvent<SystemId> {

    protected WorkerId workerId;
    protected SystemName systemName;
    protected Set<Observation> observations;
    protected Set<Product>products;
    protected Set<Position>positions;

    public System(SystemId entityId,SystemName systemName,WorkerId workerId,Set<Position> positions,Set<Product>products,Set<Observation>observations) {
        super(entityId);
        appendChange(new SystemCreated(systemName,workerId,positions,products,observations)).apply();
    }

    public void addObservation(ObservationId observationId, Description description){
        Objects.requireNonNull(observationId);
        Objects.requireNonNull(description);
        appendChange(new observationAdded(observationId,description)).apply();
    }

    public void addPosition(PositionId positionId,Stowage stowage){
        Objects.requireNonNull(positionId);
        Objects.requireNonNull(stowage);
        appendChange(new positionAdded(positionId,stowage)).apply();
    }

    public void addProduct(ProductId productId,Area area){
        Objects.requireNonNull(productId);
        Objects.requireNonNull(area);
        appendChange(new productAdded(productId,area)).apply();
    }

    public void updatePositionStowage(PositionId positionId,Stowage stowage){
        appendChange(new PositionStowageUpdated(positionId, stowage)).apply();
    }

    public void updateProductArea(ProductId productId,Area area){
        appendChange(new productAreaUpdated(productId, area)).apply();
    }

    public void updateDescription(ObservationId observationId,Description description){
        appendChange(new descriptionUpdated(observationId, description)).apply();
    }
}
