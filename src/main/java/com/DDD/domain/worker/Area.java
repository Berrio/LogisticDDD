package com.DDD.domain.worker;

import co.com.sofka.domain.generic.Entity;
import com.DDD.domain.worker.values.*;

import java.util.Objects;

public class Area extends Entity<AreaId> {

    private AreaId areaId;
    private com.DDD.domain.worker.values.Area area;

    public Area(AreaId areaId, com.DDD.domain.worker.values.Area area) {
        super(areaId);
        this.areaId = areaId;
        this.area = area;
    }

    public void updateArea(com.DDD.domain.worker.values.Area area) {
        this.area = Objects.requireNonNull(area);
    }

    public com.DDD.domain.worker.values.Area area() {
        return area;
    }

    public AreaId areaId() {
        return areaId;
    }
}