package com.DDD.domain.useCaseTest;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import com.DDD.domain.system.commands.AddProduct;
import com.DDD.domain.system.events.ProductAdded;
import com.DDD.domain.system.events.SystemCreate;
import com.DDD.domain.system.values.*;
import com.DDD.useCase.AddProductUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;


@ExtendWith(MockitoExtension.class)
public class AddProdcutUseCaseTest {

    private final String ROOTID="4";

    @Mock
    private DomainEventRepository repository;

    @Test
    void AddProduct(){
        var command= new AddProduct(SystemId.of(ROOTID),new ProductId(),new Area("B1A2"));
        var useCase= new AddProductUseCase();

        Mockito.when(repository.getEventsBy(ROOTID)).thenReturn(List.of(
                new SystemCreate(new SystemName("Aduana"))
        ));

        useCase.addRepository(repository);
        var events= UseCaseHandler
                .getInstance()
                .setIdentifyExecutor(ROOTID)
                .syncExecutor(useCase,new RequestCommand<>(command))
                .orElseThrow(()-> new IllegalArgumentException("Product Cant be added"))
                .getDomainEvents();

        var event =(ProductAdded)events.get(0);
        Assertions.assertEquals(command.getProductId(),event.productId());
        Assertions.assertEquals(command.getArea(),event.area());
        Mockito.verify(repository).getEventsBy(ROOTID);
    }
}
