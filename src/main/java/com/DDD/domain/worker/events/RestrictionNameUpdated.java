package com.DDD.domain.worker.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.DDD.domain.worker.values.RestrictionId;
import com.DDD.domain.worker.values.RestrictionName;

public class RestrictionNameUpdated extends DomainEvent {
    private final RestrictionId restrictionId;
    private final RestrictionName restrictionName;

    public RestrictionNameUpdated(RestrictionId restrictionId, RestrictionName restrictionName) {
        super("logistic.worker.");
        this.restrictionId = restrictionId;
        this.restrictionName = restrictionName;
    }

    public RestrictionName restrictionName() {
        return restrictionName;
    }

    public RestrictionId restrictionId() {
        return restrictionId;
    }
}
