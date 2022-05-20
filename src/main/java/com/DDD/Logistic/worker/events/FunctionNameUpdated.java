package com.DDD.Logistic.worker.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.DDD.Logistic.worker.values.FunctionId;
import com.DDD.Logistic.worker.values.FunctionName;

public class FunctionNameUpdated extends DomainEvent {
    private final FunctionName functionName;

    public FunctionNameUpdated(FunctionId functionId, FunctionName functionName) {
        super("logistic.worker.functionnameupdated");
        this.functionName = functionName;
    }

    public FunctionName getFunctionName() {
        return functionName;
    }
}