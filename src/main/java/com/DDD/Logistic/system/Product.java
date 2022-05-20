package com.DDD.Logistic.system;

import co.com.sofka.domain.generic.Entity;
import com.DDD.Logistic.system.values.Area;
import com.DDD.Logistic.system.values.ProductId;

import java.util.Objects;

public class Product extends Entity<ProductId> {

    private  Area area;

    public Product(ProductId productId,Area area) {
        super(productId);
        this.area=area;
    }

    public void updateArea(Area area){
        this.area= Objects.requireNonNull(area);
    }

    public Area area() {
        return area;
    }
}
