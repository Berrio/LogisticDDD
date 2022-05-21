package com.DDD.domain.system.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.DDD.domain.system.values.Area;
import com.DDD.domain.system.values.ProductId;

public class ProductAreaUpdated extends DomainEvent {

    private final ProductId productId;
    private final Area productArea;

    public ProductAreaUpdated(ProductId productId, Area area) {
        super("logistic.system.productareaupdated");
        this.productId = productId;
        this.productArea = area;
    }

    public ProductId getProductId() {
        return productId;
    }

    public Area getProductArea() {
        return productArea;
    }
}
