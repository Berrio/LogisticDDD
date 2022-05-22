package com.DDD.useCase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.DDD.domain.system.System;
import com.DDD.domain.system.commands.AddObservation;


public class AddObservationUseCase extends UseCase<RequestCommand<AddObservation>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AddObservation> addObservationRequestCommand) {
        var command=addObservationRequestCommand.getCommand();
        var system= System.from(command.getSystemId(),retrieveEvents(command.getSystemId().value()));
        system.addObservation(command.getObservationId(), command.getDescription());
        emit().onResponse(new ResponseEvents(system.getUncommittedChanges()));
    }
}
