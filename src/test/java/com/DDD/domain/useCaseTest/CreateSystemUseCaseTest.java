package com.DDD.domain.useCaseTest;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import com.DDD.domain.system.commands.CreateSystem;
import com.DDD.domain.system.events.SystemCreate;
import com.DDD.domain.system.values.SystemId;
import com.DDD.domain.system.values.SystemName;
import com.DDD.domain.worker.commands.CreateWorker;
import com.DDD.domain.worker.events.WorkerCreated;
import com.DDD.domain.worker.values.WorkerId;
import com.DDD.domain.worker.values.WorkerName;
import com.DDD.useCase.CreateSystemUseCase;
import com.DDD.useCase.CreateWorkerUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CreateSystemUseCaseTest {

    @Test
    void createSystem(){
        //Arrange
        var comand = new CreateSystem(
                SystemId.of("xxxx"),
                new SystemName("Aruto")
        );

        var useCase = new CreateSystemUseCase();

        //Act

        var events = UseCaseHandler
                .getInstance()
                .syncExecutor(useCase,new RequestCommand<>(comand))
                .orElseThrow(()-> new IllegalArgumentException("can not create te System"))
                .getDomainEvents();

        //assert
        var event=(SystemCreate)events.get(0);
        Assertions.assertEquals(comand.systemName(),event.getSystemName());
    }

}
