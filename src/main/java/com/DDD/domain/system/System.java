package com.DDD.domain.system;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import com.DDD.domain.system.events.*;
import com.DDD.domain.system.values.*;
import com.DDD.domain.worker.Worker;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public class System extends AggregateEvent<SystemId> {

    protected WorkerId workerId;
    protected SystemName systemName;
    protected Set<Observation> observations;
    protected Set<Product> products;
    protected Set<Position> positions;

    public static System from(SystemId systemId, List<DomainEvent> events) {
        var system = new System(systemId);
        events.forEach(system::applyEvent);
        return system;
    }

    public System(SystemId entityId, SystemName systemName) {
        super(entityId);
        appendChange(new SystemCreate(systemName)).apply();
    }

    private System(SystemId systemId) {
        super(systemId);
        subscribe(new SystemChange(this));
    }

    public void addObservation(ObservationId observationId, Description description) {
        Objects.requireNonNull(observationId);
        Objects.requireNonNull(description);
        appendChange(new ObservationAdded(observationId, description)).apply();
    }

    public void addPosition(PositionId positionId, Stowage stowage) {
        Objects.requireNonNull(positionId);
        Objects.requireNonNull(stowage);
        appendChange(new PositionAdded(positionId, stowage)).apply();
    }

    public void addProduct(ProductId productId, Area area) {
        Objects.requireNonNull(productId);
        Objects.requireNonNull(area);
        appendChange(new ProductAdded(productId, area)).apply();
    }

    public void updatePositionStowage(PositionId positionId, Stowage stowage) {
        appendChange(new PositionStowageUpdated(positionId, stowage)).apply();
    }

    public void updateProductArea(ProductId productId, Area area) {
        appendChange(new ProductAreaUpdated(productId, area)).apply();
    }

    public void updateDescription(ObservationId observationId, Description description) {
        appendChange(new DescriptionUpdated(observationId, description)).apply();
    }

    protected Optional<Observation> getObservationById(ObservationId entityId) {
        return observations()
                .stream()
                .filter(observation -> observation.identity().equals(entityId))
                .findFirst();
    }

    protected Optional<Product> getProductById(ProductId entityId) {
        return products()
                .stream()
                .filter(product -> product.identity().equals(entityId))
                .findFirst();
    }

    protected Optional<Position> getPositionById(PositionId entityId) {
        return positions()
                .stream()
                .filter(position -> position.identity().equals(entityId))
                .findFirst();
    }

    public WorkerId workerId() {
        return workerId;
    }

    public SystemName systemName() {
        return systemName;
    }

    public Set<Observation> observations() {
        return observations;
    }

    public Set<Product> products() {
        return products;
    }

    public Set<Position> positions() {
        return positions;
    }
}
