package com.DDD.useCase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.DDD.domain.system.System;
import com.DDD.domain.system.commands.CreateSystem;
import com.DDD.domain.worker.Worker;
import com.DDD.domain.worker.commands.CreateWorker;

public class CreateSystemUseCase extends UseCase<RequestCommand<CreateSystem>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<CreateSystem> createSystemRequestCommand) {
        var command=createSystemRequestCommand.getCommand();
        var system = new System(
                command.systemId(),
                command.systemName()
        );

        emit().onResponse(new ResponseEvents(system.getUncommittedChanges()));
    }
}

