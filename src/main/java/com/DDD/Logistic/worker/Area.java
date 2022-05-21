package com.DDD.Logistic.worker;

import co.com.sofka.domain.generic.Entity;
import com.DDD.Logistic.worker.values.*;

import java.util.Objects;

public class Area  extends Entity<AreaId> {

    private AreaId areaId;
    private com.DDD.Logistic.worker.values.Area area;

    public Area(AreaId areaId, com.DDD.Logistic.worker.values.Area area) {
        super(areaId);
        this.areaId=areaId;
        this.area=area;
    }
    public void updateArea(com.DDD.Logistic.worker.values.Area area){
        this.area= Objects.requireNonNull(area);
    }

    public com.DDD.Logistic.worker.values.Area area() {
        return area;
    }

    public AreaId areaId() {
        return areaId;
    }
}