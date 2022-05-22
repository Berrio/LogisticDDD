package com.DDD.domain.useCaseTest;


import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.TriggeredEvent;
import com.DDD.domain.worker.Worker;
import com.DDD.domain.worker.events.FunctionAdded;
import com.DDD.domain.worker.events.FunctionNameUpdated;
import com.DDD.domain.worker.events.WorkerCreated;
import com.DDD.domain.worker.values.FunctionId;
import com.DDD.domain.worker.values.FunctionName;
import com.DDD.domain.worker.values.WorkerId;
import com.DDD.domain.worker.values.WorkerName;
import com.DDD.useCase.EventFunctionNameAddedUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class EventFunctionNameAddedUseCaseTest {

    private final String ROOTID = "2";

    @Mock
    private DomainEventRepository repository;


    @Test
    void Event() {
        var event=new FunctionNameUpdated(new FunctionId(),new FunctionName("supervisor"));
        var useCase=new EventFunctionNameAddedUseCase();


    Mockito.when(repository.getEventsBy(ROOTID)).thenReturn(List.of(
            new WorkerCreated(new WorkerName("mock"))
    ));
        useCase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(ROOTID)
                .syncExecutor(useCase, new TriggeredEvent<>(event))
                .orElseThrow()
                .getDomainEvents();

        var function=(FunctionNameUpdated)events.get(0);
        Assertions.assertEquals(event.getFunctionId(),function.getFunctionId());
        Assertions.assertEquals(event.getFunctionName(),function.getFunctionName());
        Mockito.verify(repository).getEventsBy(ROOTID);

    }
}
