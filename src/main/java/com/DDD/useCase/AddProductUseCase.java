package com.DDD.useCase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.DDD.domain.system.System;
import com.DDD.domain.system.commands.AddProduct;

public class AddProductUseCase extends UseCase<RequestCommand<AddProduct>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AddProduct> addPositionRequestCommand) {
        var command=addPositionRequestCommand.getCommand();
        var system= System.from(command.getSystemId(),retrieveEvents(command.getSystemId().value()));
        system.addProduct(command.getProductId(), command.getArea());
        emit().onResponse(new ResponseEvents(system.getUncommittedChanges()));
    }
}
