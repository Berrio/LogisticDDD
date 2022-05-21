package com.DDD.Logistic.worker.commands;

import co.com.sofka.domain.generic.Command;
import com.DDD.Logistic.worker.values.FunctionId;
import com.DDD.Logistic.worker.values.FunctionName;
import com.DDD.Logistic.worker.values.WorkerId;

public class UpdateFunctionName extends Command {

    private final WorkerId workerId;
    private final FunctionId functionId;
    private final FunctionName functionName;

    public UpdateFunctionName(WorkerId workerId, FunctionId functionId, FunctionName functionName) {
        this.workerId = workerId;
        this.functionId = functionId;
        this.functionName = functionName;
    }

    public WorkerId getWorkerId() {
        return workerId;
    }

    public FunctionId getFunctionId() {
        return functionId;
    }

    public FunctionName getFunctionName() {
        return functionName;
    }
}
