package com.DDD.domain.useCaseTest;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import com.DDD.domain.worker.commands.AddArea;
import com.DDD.domain.worker.commands.AddFunction;
import com.DDD.domain.worker.events.AreaAdded;
import com.DDD.domain.worker.events.FunctionAdded;
import com.DDD.domain.worker.events.WorkerCreated;
import com.DDD.domain.worker.values.*;
import com.DDD.useCase.AddAreaWorkerUseCase;
import com.DDD.useCase.AddFunctionWorkerUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;


@ExtendWith(MockitoExtension.class)
public class AddFunctionWorkerUseCaseTest {

    private final String ROOTID="2";

    @Mock
    private DomainEventRepository repository;

    @Test
    void AddFunctionWorker(){
        var command= new AddFunction(WorkerId.of(ROOTID),new FunctionId(),new FunctionName("Picker"));
        var useCase= new AddFunctionWorkerUseCase();

        Mockito.when(repository.getEventsBy(ROOTID)).thenReturn(List.of(
                new WorkerCreated(new WorkerName("Yerry"))
        ));

        useCase.addRepository(repository);
        var events= UseCaseHandler
                .getInstance()
                .setIdentifyExecutor(ROOTID)
                .syncExecutor(useCase,new RequestCommand<>(command))
                .orElseThrow(()-> new IllegalArgumentException("Add Function Cant be created"))
                .getDomainEvents();

        var event =(FunctionAdded)events.get(0);
        Assertions.assertEquals(command.getFunctionId(),event.functionId());
        Assertions.assertEquals(command.getFunctionName(),event.functionName());
        Mockito.verify(repository).getEventsBy(ROOTID);
    }
}
