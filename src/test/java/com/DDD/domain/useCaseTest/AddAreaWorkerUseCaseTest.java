package com.DDD.domain.useCaseTest;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import com.DDD.domain.worker.commands.AddArea;
import com.DDD.domain.worker.events.AreaAdded;
import com.DDD.domain.worker.events.WorkerCreated;
import com.DDD.domain.worker.values.Area;
import com.DDD.domain.worker.values.AreaId;
import com.DDD.domain.worker.values.WorkerId;
import com.DDD.domain.worker.values.WorkerName;
import com.DDD.useCase.AddAreaWorkerUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class AddAreaWorkerUseCaseTest {

    private final String ROOTID="1";

    @Mock
    private DomainEventRepository repository;

    @Test
    void AddAreaWorker(){
        var command= new AddArea(WorkerId.of(ROOTID),new AreaId(),new Area("A1B2"));
        var useCase= new AddAreaWorkerUseCase();

        Mockito.when(repository.getEventsBy(ROOTID)).thenReturn(List.of(
              new WorkerCreated(new WorkerName("Alpes"))
        ));

        useCase.addRepository(repository);
        var events= UseCaseHandler
                .getInstance()
                .setIdentifyExecutor(ROOTID)
                .syncExecutor(useCase,new RequestCommand<>(command))
                .orElseThrow(()-> new IllegalArgumentException("Add Area Cant be created"))
                .getDomainEvents();

        var event =(AreaAdded)events.get(0);
        Assertions.assertEquals(command.areaId(),event.areaId());
        Assertions.assertEquals(command.area(),event.area());
        Mockito.verify(repository).getEventsBy(ROOTID);
    }
}
