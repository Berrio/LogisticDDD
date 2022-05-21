package com.DDD.domain.worker.commands;

import co.com.sofka.domain.generic.Command;
import com.DDD.domain.system.values.SystemId;
import com.DDD.domain.system.values.SystemName;
import com.DDD.domain.worker.values.WorkerId;

public class AssociateSystem extends Command {

    private final WorkerId workerId;
    private final SystemId systemId;
    private final SystemName systemName;

    public AssociateSystem(WorkerId workerId, SystemId systemId, SystemName systemName) {
        this.workerId = workerId;
        this.systemId = systemId;
        this.systemName = systemName;
    }

    public WorkerId workerId() {
        return workerId;
    }

    public SystemId systemId() {
        return systemId;
    }

    public SystemName getSystemName() {
        return systemName;
    }
}
