package com.DDD.domain.worker.commands;

import co.com.sofka.domain.generic.Command;
import com.DDD.domain.worker.values.*;

public class AddArea extends Command {

    private final WorkerId workerId;
    private final AreaId areaId;
    private final Area Area;

    public AddArea(WorkerId workerId, AreaId areaId, com.DDD.domain.worker.values.Area area) {
        this.workerId = workerId;
        this.areaId = areaId;
        Area = area;
    }

    public WorkerId workerId() {
        return workerId;
    }

    public AreaId areaId() {
        return areaId;
    }

    public Area area() {
        return Area;
    }
}
