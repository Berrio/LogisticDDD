package com.DDD.domain.worker.commands;

import co.com.sofka.domain.generic.Command;
import com.DDD.domain.system.values.SystemId;
import com.DDD.domain.worker.Area;
import com.DDD.domain.worker.Function;
import com.DDD.domain.worker.Restriction;
import com.DDD.domain.worker.values.WorkerId;
import com.DDD.domain.worker.values.WorkerName;

import java.util.Set;

public class CreateWorker extends Command {

    protected WorkerId workerId;
    protected WorkerName workerName;


    public CreateWorker(WorkerId workerId,WorkerName workerName) {

        this.workerId = workerId;
        this.workerName=workerName;

    }

    public WorkerId workerId() {
        return workerId;
    }

    public WorkerName workerName() {
        return workerName;
    }


}
