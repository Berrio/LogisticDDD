package com.DDD.useCase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.DDD.domain.worker.Worker;
import com.DDD.domain.worker.commands.AddFunction;

public class AddFunctionWorkerUseCase extends UseCase<RequestCommand<AddFunction>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AddFunction> addAreaRequestCommand) {
        var command=addAreaRequestCommand.getCommand();
        var worker= Worker.from(command.getWorkerId(),retrieveEvents(command.getWorkerId().value()));
        worker.addFunction(command.getFunctionId(), command.getFunctionName());
        emit().onResponse(new ResponseEvents(worker.getUncommittedChanges()));
    }
}


