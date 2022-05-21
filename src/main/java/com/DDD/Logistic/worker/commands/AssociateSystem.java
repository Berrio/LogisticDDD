package com.DDD.Logistic.worker.commands;

import co.com.sofka.domain.generic.Command;
import com.DDD.Logistic.system.values.SystemId;
import com.DDD.Logistic.worker.Worker;
import com.DDD.Logistic.worker.values.WorkerId;

public class AssociateSystem extends Command {

    private final WorkerId workerId;
    private final SystemId systemId;

    public AssociateSystem(WorkerId workerId, SystemId systemId) {
        this.workerId = workerId;
        this.systemId = systemId;
    }

    public WorkerId workerId() {
        return workerId;
    }

    public SystemId systemId() {
        return systemId;
    }
}
