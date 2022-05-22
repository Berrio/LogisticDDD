package com.DDD.domain.useCaseTest;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import com.DDD.domain.system.commands.AddPosition;
import com.DDD.domain.system.events.PositionAdded;
import com.DDD.domain.system.events.SystemCreate;
import com.DDD.domain.system.values.*;
import com.DDD.useCase.AddPositionUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;


@ExtendWith(MockitoExtension.class)
public class AddPositionUseCaseTest {

    private final String ROOTID="5";

    @Mock
    private DomainEventRepository repository;

    @Test
    void AddPosition(){
        var command= new AddPosition(SystemId.of(ROOTID),new PositionId(),new Stowage("1/2 stowage"));
        var useCase= new AddPositionUseCase();

        Mockito.when(repository.getEventsBy(ROOTID)).thenReturn(List.of(
                new SystemCreate(new SystemName("picker"))
        ));

        useCase.addRepository(repository);
        var events= UseCaseHandler
                .getInstance()
                .setIdentifyExecutor(ROOTID)
                .syncExecutor(useCase,new RequestCommand<>(command))
                .orElseThrow(()-> new IllegalArgumentException("Position Cant be added"))
                .getDomainEvents();

        var event =(PositionAdded)events.get(0);
        Assertions.assertEquals(command.getPositionId(),event.getPositionId());
        Assertions.assertEquals(command.getStowage(),event.getStowage());
        Mockito.verify(repository).getEventsBy(ROOTID);
    }
}
