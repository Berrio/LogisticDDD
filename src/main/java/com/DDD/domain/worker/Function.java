package com.DDD.domain.worker;

import co.com.sofka.domain.generic.Entity;
import com.DDD.domain.worker.values.FunctionId;
import com.DDD.domain.worker.values.FunctionName;

import java.util.Objects;

public class Function extends Entity<FunctionId> {

    private FunctionName functionName;

    public Function(FunctionId functionId, FunctionName functionName) {
        super(functionId);
        this.functionName = functionName;
    }

    public void updateFunctionName(FunctionName functionName) {
        this.functionName = Objects.requireNonNull(functionName);
    }

    public FunctionName functionName() {
        return functionName;
    }
}
