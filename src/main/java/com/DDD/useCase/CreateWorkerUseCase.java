package com.DDD.useCase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.DDD.domain.worker.Worker;
import com.DDD.domain.worker.commands.CreateWorker;

public class CreateWorkerUseCase extends UseCase<RequestCommand<CreateWorker>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<CreateWorker> createWorkerRequestCommand) {
        var command=createWorkerRequestCommand.getCommand();
        var worker = new Worker(
                command.workerId(),
                command.workerName()
        );

        emit().onResponse(new ResponseEvents(worker.getUncommittedChanges()));
    }
}
