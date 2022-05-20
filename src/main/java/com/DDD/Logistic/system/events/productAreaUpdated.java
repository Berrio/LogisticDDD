package com.DDD.Logistic.system.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.DDD.Logistic.system.values.Area;
import com.DDD.Logistic.system.values.Description;
import com.DDD.Logistic.system.values.ProductId;

public class productAreaUpdated extends DomainEvent {

    private final Area area;

    public productAreaUpdated(ProductId productId, Area area) {
        super("logistic.system.productareaupdated");
        this.area=area;
    }
}
