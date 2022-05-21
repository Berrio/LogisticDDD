package com.DDD.Logistic.worker.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.domain.generic.EventChange;
import com.DDD.Logistic.worker.values.WorkerName;


import java.util.Set;

public class WorkerCreated extends DomainEvent {

    private final WorkerName workerName;

    public WorkerCreated(WorkerName workerName){
        super("logistic.worker.workercreated");
        this.workerName=workerName;
    }

    public WorkerName getWorkerName() {
        return workerName;
    }
}
