package com.DDD.Logistic.worker.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.DDD.Logistic.worker.values.RestrictionId;
import com.DDD.Logistic.worker.values.RestrictionName;

public class RestrictionAdded extends DomainEvent {
    private final RestrictionName restrictionName;

    public RestrictionAdded(RestrictionId restrictionId, RestrictionName restrictionName) {
        super("logistic.worker.restrictionadded");
        this.restrictionName = restrictionName;
    }

    public RestrictionName getRestrictionName() {
        return restrictionName;
    }
}
