package com.DDD.domain.worker.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.DDD.domain.system.values.SystemId;
import com.DDD.domain.system.values.SystemName;

public class SystemAssociated extends DomainEvent {

    private final SystemId systemId;
    private final SystemName systemName;

    public SystemAssociated(SystemId systemId, SystemName systemName) {
        super("logistic.worker.systemassociated");
        this.systemId = systemId;
        this.systemName = systemName;
    }

    public SystemId getSystemId() {
        return systemId;
    }

    public SystemName getSystemName() {
        return systemName;
    }
}
