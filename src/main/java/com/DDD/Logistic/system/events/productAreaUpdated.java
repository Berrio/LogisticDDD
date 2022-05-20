package com.DDD.Logistic.system.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.DDD.Logistic.system.values.Area;
import com.DDD.Logistic.system.values.ProductId;

public class productAreaUpdated extends DomainEvent {
    public productAreaUpdated(ProductId productId, Area area) {
        super();
    }
}
