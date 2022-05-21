package com.DDD.domain.worker.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.DDD.domain.worker.values.Area;
import com.DDD.domain.worker.values.AreaId;

public class AreaAdded extends DomainEvent {


    private final AreaId areaId;
    private final Area area;

    public AreaAdded(AreaId areaId, Area area) {
        super("logistic.worker.areaadded");
        this.area = area;
        this.areaId = areaId;
    }

    public Area area() {
        return area;
    }

    public AreaId areaId() {
        return areaId;
    }
}
