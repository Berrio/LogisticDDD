package com.DDD.domain.useCaseTest;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import com.DDD.domain.system.commands.AddPosition;
import com.DDD.domain.system.commands.UpdatePositionStowage;
import com.DDD.domain.system.events.PositionAdded;
import com.DDD.domain.system.events.PositionStowageUpdated;
import com.DDD.domain.system.events.SystemCreate;
import com.DDD.domain.system.values.PositionId;
import com.DDD.domain.system.values.Stowage;
import com.DDD.domain.system.values.SystemId;
import com.DDD.domain.system.values.SystemName;
import com.DDD.useCase.AddPositionUseCase;
import com.DDD.useCase.PositionStowageUpdatedUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class UpdatePositionStowageUseCaseTest {

    private final String ROOTID="5";

    @Mock
    private DomainEventRepository repository;

    @Test
    void UpdatePositionStowage(){
        var command= new UpdatePositionStowage(SystemId.of(ROOTID),PositionId.of("x"),new Stowage("1 stowage"));
        var useCase= new PositionStowageUpdatedUseCase();

        Mockito.when(repository.getEventsBy(ROOTID)).thenReturn(List.of(
                new SystemCreate(new SystemName("picker"))
        ));

        useCase.addRepository(repository);
        var events= UseCaseHandler
                .getInstance()
                .setIdentifyExecutor(ROOTID)
                .syncExecutor(useCase,new RequestCommand<>(command))
                .orElseThrow(()-> new IllegalArgumentException("Stowage Cant be updated"))
                .getDomainEvents();

        var event =(PositionStowageUpdated)events.get(0);
        Assertions.assertEquals(command.getPositionId(),event.getPositionId());
        Assertions.assertEquals(command.getStowage(),event.getStowage());
        Mockito.verify(repository).getEventsBy(ROOTID);
        System.out.println(command.getPositionId());
        System.out.println(event.getPositionId());
    }
}