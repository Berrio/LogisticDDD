package com.DDD.Logistic.system.commands;

import co.com.sofka.domain.generic.Command;
import com.DDD.Logistic.system.values.Area;
import com.DDD.Logistic.system.values.ProductId;
import com.DDD.Logistic.system.values.SystemId;

public class AddProduct extends Command {

    private final SystemId systemId;
    private final ProductId productId;
    private final Area area;

    public AddProduct(SystemId systemId, ProductId productId, Area area) {
        this.systemId = systemId;
        this.productId = productId;
        this.area = area;
    }

    public SystemId getSystemId() {
        return systemId;
    }

    public ProductId getProductId() {
        return productId;
    }

    public Area getArea() {
        return area;
    }
}
