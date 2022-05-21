package com.DDD.domain.worker.commands;

import co.com.sofka.domain.generic.Command;
import com.DDD.domain.worker.values.AreaId;
import com.DDD.domain.worker.values.Area;
import com.DDD.domain.worker.values.WorkerId;

public class UpdateAreaName extends Command {

    private final WorkerId workerId;
    private final AreaId areaId;
    private final Area Area;

    public UpdateAreaName(WorkerId workerId, AreaId areaId, Area area) {
        this.workerId = workerId;
        this.areaId = areaId;
        Area = area;
    }

    public WorkerId getWorkerId() {
        return workerId;
    }

    public AreaId getAreaId() {
        return areaId;
    }

    public Area getArea() {
        return Area;
    }
}
