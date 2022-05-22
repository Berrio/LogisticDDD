package com.DDD.useCase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.DDD.domain.worker.Worker;
import com.DDD.domain.worker.commands.AssociateSystem;

public class AsociateSystemUseCase extends UseCase<RequestCommand<AssociateSystem>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AssociateSystem> associateSystemRequestCommand) {
        var command=associateSystemRequestCommand.getCommand();
        var worker= Worker.from(command.workerId(),retrieveEvents(command.workerId().value()));
        worker.associateSystem(command.systemId(),command.getSystemName());
        emit().onResponse(new ResponseEvents(worker.getUncommittedChanges()));
    }
}
