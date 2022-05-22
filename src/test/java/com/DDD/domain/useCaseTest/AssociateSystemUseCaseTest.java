package com.DDD.domain.useCaseTest;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import com.DDD.domain.system.values.SystemId;
import com.DDD.domain.system.values.SystemName;
import com.DDD.domain.worker.commands.AddArea;
import com.DDD.domain.worker.commands.AssociateSystem;
import com.DDD.domain.worker.events.AreaAdded;
import com.DDD.domain.worker.events.SystemAssociated;
import com.DDD.domain.worker.events.WorkerCreated;
import com.DDD.domain.worker.values.Area;
import com.DDD.domain.worker.values.AreaId;
import com.DDD.domain.worker.values.WorkerId;
import com.DDD.domain.worker.values.WorkerName;
import com.DDD.useCase.AddAreaWorkerUseCase;
import com.DDD.useCase.AsociateSystemUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;


@ExtendWith(MockitoExtension.class)
public class AssociateSystemUseCaseTest {

    private final String ROOTID="1";

    @Mock
    private DomainEventRepository repository;

    @Test
    void AssociateSystem(){
        var command= new AssociateSystem(WorkerId.of(ROOTID),new SystemId(),new SystemName("Aduana"));
        var useCase= new AsociateSystemUseCase();

        Mockito.when(repository.getEventsBy(ROOTID)).thenReturn(List.of(
                new WorkerCreated(new WorkerName("Alpes"))
        ));

        useCase.addRepository(repository);
        var events= UseCaseHandler
                .getInstance()
                .setIdentifyExecutor(ROOTID)
                .syncExecutor(useCase,new RequestCommand<>(command))
                .orElseThrow(()-> new IllegalArgumentException("System Cant be created"))
                .getDomainEvents();

        var event =(SystemAssociated)events.get(0);
        Assertions.assertEquals(command.systemId(),event.getSystemId());
        Assertions.assertEquals(command.getSystemName(),event.getSystemName());
        Mockito.verify(repository).getEventsBy(ROOTID);
    }
}
