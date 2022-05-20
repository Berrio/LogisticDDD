package com.DDD.Logistic.worker.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.DDD.Logistic.worker.Area;
import com.DDD.Logistic.worker.values.AreaId;

public class AreaAdded extends DomainEvent {
    private final Area area;

    public AreaAdded(AreaId areaId, Area area) {
        super("logistic.worker.areaadded");
        this.area = area;
    }

    public Area getArea() {
        return area;
    }
}
