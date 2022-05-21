package com.DDD.useCase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.DDD.domain.worker.Worker;
import com.DDD.domain.worker.commands.AddFunction;
import com.DDD.domain.worker.commands.AddRestiction;

public class AddRestrictionUseCase extends UseCase<RequestCommand<AddRestiction>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AddRestiction> addRestictionRequestCommand) {
        var command=addRestictionRequestCommand.getCommand();
        var worker= Worker.from(command.getWorkerId(),retrieveEvents(command.getWorkerId().value()));
        worker.addRestiction(command.getRestrictionId(), command.getRestrictionName());
        emit().onResponse(new ResponseEvents(worker.getUncommittedChanges()));
    }
}

