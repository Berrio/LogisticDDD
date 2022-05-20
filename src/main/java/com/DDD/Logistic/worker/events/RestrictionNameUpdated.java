package com.DDD.Logistic.worker.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.DDD.Logistic.worker.values.RestrictionId;
import com.DDD.Logistic.worker.values.RestrictionName;

public class RestrictionNameUpdated extends DomainEvent {
    private final RestrictionName restrictionName;

    public RestrictionNameUpdated(RestrictionId restrictionId, RestrictionName restrictionName) {
        super("logistic.worker.");
        this.restrictionName = restrictionName;
    }

    public RestrictionName getRestrictionName() {
        return restrictionName;
    }
}
