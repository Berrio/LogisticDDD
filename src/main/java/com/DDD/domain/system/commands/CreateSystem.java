package com.DDD.domain.system.commands;

import co.com.sofka.domain.generic.Command;
import com.DDD.domain.system.values.SystemName;
import com.DDD.domain.system.values.SystemId;

public class CreateSystem extends Command {

    protected SystemId systemId;
    protected SystemName systemName;

    public CreateSystem(SystemId systemId, SystemName systemName) {
        this.systemId = systemId;
        this.systemName = systemName;
    }

    public SystemId systemId() {
        return systemId;
    }

    public SystemName systemName() {
        return systemName;
    }
}
