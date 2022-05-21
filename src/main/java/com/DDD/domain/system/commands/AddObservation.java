package com.DDD.domain.system.commands;

import co.com.sofka.domain.generic.Command;
import com.DDD.domain.system.Observation;
import com.DDD.domain.system.values.ObservationId;
import com.DDD.domain.system.values.SystemId;

public class AddObservation extends Command {

    private final SystemId systemId;
    private final ObservationId observationId;
    private final Observation observation;

    public AddObservation(SystemId systemId, ObservationId observationId, Observation observation) {
        this.systemId = systemId;
        this.observationId = observationId;
        this.observation = observation;
    }

    public SystemId getSystemId() {
        return systemId;
    }

    public ObservationId getObservationId() {
        return observationId;
    }

    public Observation getObservation() {
        return observation;
    }
}
