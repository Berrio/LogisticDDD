package com.DDD.useCase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.DDD.domain.system.System;
import com.DDD.domain.system.commands.AddPosition;
import com.DDD.domain.system.commands.UpdatePositionStowage;

public class PositionStowageUpdatedUseCase extends UseCase<RequestCommand<UpdatePositionStowage>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<UpdatePositionStowage> updatePositionStowageRequestCommand) {
        var command=updatePositionStowageRequestCommand.getCommand();
        var system= System.from(command.getSystemId(),retrieveEvents(command.getSystemId().value()));
        system.updatePositionStowage(command.getPositionId(), command.getStowage());
        emit().onResponse(new ResponseEvents(system.getUncommittedChanges()));
    }
}