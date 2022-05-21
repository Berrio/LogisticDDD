package com.DDD.Logistic.worker.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.DDD.Logistic.system.values.SystemId;

public class SystemAssociated extends DomainEvent {

    private final SystemId systemId;

    public SystemAssociated(SystemId systemId) {
        super("logistic.worker.systemassociated");
        this.systemId=systemId;
    }

    public SystemId getSystemId() {
        return systemId;
    }
}
