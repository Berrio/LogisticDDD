package com.DDD.domain.system.commands;

import co.com.sofka.domain.generic.Command;
import com.DDD.domain.system.Observation;
import com.DDD.domain.system.values.Description;
import com.DDD.domain.system.values.ObservationId;
import com.DDD.domain.system.values.SystemId;

public class AddObservation extends Command {

    private final SystemId systemId;
    private final ObservationId observationId;
    private final Description description;

    public AddObservation(SystemId systemId, ObservationId observationId, Description description) {
        this.systemId = systemId;
        this.observationId = observationId;
        this.description = description;
    }

    public SystemId getSystemId() {
        return systemId;
    }

    public ObservationId getObservationId() {
        return observationId;
    }

    public Description getDescription() {
        return description;
    }
}
