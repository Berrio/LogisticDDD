package com.DDD.domain.useCaseTest;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import com.DDD.domain.worker.commands.CreateWorker;
import com.DDD.domain.worker.events.WorkerCreated;
import com.DDD.domain.worker.values.WorkerId;
import com.DDD.domain.worker.values.WorkerName;
import com.DDD.useCase.CreateWorkerUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class CreateWorkerUseCaseTest {

    @Test
    void createWorker(){
         //Arrange
        var comand = new CreateWorker(
                WorkerId.of("1"),
                new WorkerName("Aruto")
        );

        var useCase = new CreateWorkerUseCase();

        //Act

        var events = UseCaseHandler
                .getInstance()
                .syncExecutor(useCase,new RequestCommand<>(comand))
                .orElseThrow(()-> new IllegalArgumentException("can not create te worker"))
                .getDomainEvents();

        //assert
        var event=(WorkerCreated)events.get(0);
        Assertions.assertEquals(comand.workerName(),event.getWorkerName());
    }
}
