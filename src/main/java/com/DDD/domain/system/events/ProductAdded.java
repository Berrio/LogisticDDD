package com.DDD.domain.system.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.DDD.domain.system.values.Area;
import com.DDD.domain.system.values.ProductId;

public class ProductAdded extends DomainEvent {

    private final ProductId productId;
    private final Area area;

    public ProductAdded(ProductId productId, Area area) {
        super("logistic.system.productadded");
        this.productId = productId;
        this.area = area;
    }

    public Area area() {
        return area;
    }

    public ProductId productId() {
        return productId;
    }
}
