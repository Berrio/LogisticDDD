package com.DDD.domain.worker.commands;

import co.com.sofka.domain.generic.Command;
import com.DDD.domain.worker.values.FunctionId;
import com.DDD.domain.worker.values.FunctionName;
import com.DDD.domain.worker.values.WorkerId;

public class AddFunction extends Command {

    private final WorkerId workerId;
    private final FunctionId functionId;
    private final FunctionName functionName;

    public AddFunction(WorkerId workerId, FunctionId functionId, FunctionName functionName) {
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
