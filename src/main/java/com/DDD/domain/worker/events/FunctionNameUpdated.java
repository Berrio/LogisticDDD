package com.DDD.domain.worker.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.DDD.domain.worker.values.FunctionId;
import com.DDD.domain.worker.values.FunctionName;

public class FunctionNameUpdated extends DomainEvent {

    private final FunctionId functionId;
    private final FunctionName functionName;

    public FunctionNameUpdated(FunctionId functionId, FunctionName functionName) {
        super("logistic.worker.functionnameupdated");
        this.functionId = functionId;
        this.functionName = functionName;
    }

    public FunctionName getFunctionName() {
        return functionName;
    }

    public FunctionId getFunctionId() {
        return functionId;
    }
}
