package com.DDD.useCase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.DDD.domain.worker.Worker;
import com.DDD.domain.worker.commands.AddArea;


public class AddAreaWorkerUseCase extends UseCase<RequestCommand<AddArea>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AddArea> addAreaRequestCommand) {
        var command=addAreaRequestCommand.getCommand();
        var worker=Worker.from(command.workerId(),retrieveEvents(command.workerId().value()));
        worker.addArea(command.areaId(), command.area());
        emit().onResponse(new ResponseEvents(worker.getUncommittedChanges()));
    }
}
