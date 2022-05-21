package com.DDD.domain.worker.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.DDD.domain.worker.values.FunctionId;
import com.DDD.domain.worker.values.FunctionName;

public class FunctionAdded extends DomainEvent {
    private final FunctionId functionId;
    private final FunctionName functionName;

    public FunctionAdded(FunctionId functionId, FunctionName functionName) {
        super("logistic.worker.functionadded");
        this.functionName = functionName;
        this.functionId = functionId;
    }

    public FunctionName functionName() {
        return functionName;
    }

    public FunctionId functionId() {
        return functionId;
    }
}
