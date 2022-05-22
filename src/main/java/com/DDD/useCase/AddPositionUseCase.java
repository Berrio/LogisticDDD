package com.DDD.useCase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.DDD.domain.system.System;
import com.DDD.domain.system.commands.AddPosition;

public class AddPositionUseCase extends UseCase<RequestCommand<AddPosition>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AddPosition> addPositionRequestCommand) {
        var command=addPositionRequestCommand.getCommand();
        var system= System.from(command.getSystemId(),retrieveEvents(command.getSystemId().value()));
        system.addPosition(command.getPositionId(), command.getStowage());
        emit().onResponse(new ResponseEvents(system.getUncommittedChanges()));
    }
}
