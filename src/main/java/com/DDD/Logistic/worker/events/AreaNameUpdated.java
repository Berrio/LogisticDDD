package com.DDD.Logistic.worker.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.DDD.Logistic.worker.values.Area;
import com.DDD.Logistic.worker.values.AreaId;

public class AreaNameUpdated extends DomainEvent {

    private final AreaId areaId;
    private final Area area;

    public AreaNameUpdated(AreaId areaId, Area area) {
        super("logistic.worker.areanameupdated");
        this.areaId = areaId;
        this.area = area;
    }

    public Area getArea() {
        return area;
    }

    public AreaId getAreaId() {
        return areaId;
    }
}
