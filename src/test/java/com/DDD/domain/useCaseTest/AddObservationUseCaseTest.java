package com.DDD.domain.useCaseTest;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import com.DDD.domain.system.Observation;
import com.DDD.domain.system.commands.AddObservation;
import com.DDD.domain.system.events.ObservationAdded;
import com.DDD.domain.system.events.SystemCreate;
import com.DDD.domain.system.values.Description;
import com.DDD.domain.system.values.ObservationId;
import com.DDD.domain.system.values.SystemId;
import com.DDD.domain.system.values.SystemName;
import com.DDD.domain.worker.commands.AddArea;
import com.DDD.domain.worker.events.AreaAdded;
import com.DDD.domain.worker.events.WorkerCreated;
import com.DDD.domain.system.Observation;
import com.DDD.domain.worker.values.WorkerName;
import com.DDD.useCase.AddAreaWorkerUseCase;
import com.DDD.useCase.AddObservationUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;


@ExtendWith(MockitoExtension.class)
public class AddObservationUseCaseTest {

    private final String ROOTID="1";

    @Mock
    private DomainEventRepository repository;

    @Test
    void AddObservation(){
        var command= new AddObservation(SystemId.of(ROOTID),new ObservationId(),new Description("System picker is having probles"));
        var useCase= new AddObservationUseCase();

        Mockito.when(repository.getEventsBy(ROOTID)).thenReturn(List.of(
                new SystemCreate(new SystemName("picker"))
        ));

        useCase.addRepository(repository);
        var events= UseCaseHandler
                .getInstance()
                .setIdentifyExecutor(ROOTID)
                .syncExecutor(useCase,new RequestCommand<>(command))
                .orElseThrow(()-> new IllegalArgumentException("Observation Cant be added"))
                .getDomainEvents();

        var event =(ObservationAdded)events.get(0);
        Assertions.assertEquals(command.getObservationId(),event.getObservationId());
        Assertions.assertEquals(command.getDescription(),event.getDescription());
        Mockito.verify(repository).getEventsBy(ROOTID);
    }
}
