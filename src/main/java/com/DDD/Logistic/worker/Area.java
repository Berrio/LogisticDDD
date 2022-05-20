package com.DDD.Logistic.worker;

import co.com.sofka.domain.generic.Entity;
import com.DDD.Logistic.system.values.PositionId;
import com.DDD.Logistic.system.values.Stowage;
import com.DDD.Logistic.worker.values.AreaId;

import java.util.Objects;

public class Area  extends Entity<AreaId> {

    private Area area;

    public Area(AreaId areaId, Area area) {
        super(areaId);
        this.area=area;
    }
    public void updateArea(Area area){
        this.area= Objects.requireNonNull(area);
    }

    public Area area() {
        return area;
    }
}