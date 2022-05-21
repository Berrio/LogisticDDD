package com.DDD.Logistic.system.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.DDD.Logistic.system.values.Area;
import com.DDD.Logistic.system.values.ProductId;

public class ProductAdded extends DomainEvent {

    private final ProductId productId;
    private final Area area;

    public ProductAdded(ProductId productId, Area area) {
        super("logistic.system.productadded");
        this.productId=productId;
        this.area=area;
    }

    public Area area() {
        return area;
    }

    public ProductId productId() {
        return productId;
    }
}
