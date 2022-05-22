package com.DDD.useCase;


import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import com.DDD.domain.worker.Worker;
import com.DDD.domain.worker.events.FunctionAdded;
import com.DDD.domain.worker.events.FunctionNameUpdated;
import com.DDD.domain.worker.values.FunctionId;
import com.DDD.domain.worker.values.FunctionName;
import com.DDD.domain.worker.values.WorkerId;

public class EventFunctionNameAddedUseCase extends UseCase<TriggeredEvent<FunctionNameUpdated>, ResponseEvents> {

    @Override
    public void executeUseCase(TriggeredEvent<FunctionNameUpdated> functionNameUpdatedTriggeredEvent){
        var event=functionNameUpdatedTriggeredEvent.getDomainEvent();
        var worker= Worker.from(WorkerId.of(event.aggregateRootId()),this.retrieveEvents());

        emit().onResponse(new ResponseEvents(worker.getUncommittedChanges()));
    }
}