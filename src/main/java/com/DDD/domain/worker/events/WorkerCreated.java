package com.DDD.domain.worker.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.DDD.domain.worker.values.WorkerName;

public class WorkerCreated extends DomainEvent {

    private final WorkerName workerName;

    public WorkerCreated(WorkerName workerName) {
        super("logistic.worker.workercreated");
        this.workerName = workerName;
    }

    public WorkerName getWorkerName() {
        return workerName;
    }
}
