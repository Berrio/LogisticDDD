package com.DDD.Logistic.worker.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.DDD.Logistic.worker.values.RestrictionId;
import com.DDD.Logistic.worker.values.RestrictionName;

public class RestrictionAdded extends DomainEvent {
    private final RestrictionId restrictionId;
    private final RestrictionName restrictionName;

    public RestrictionAdded(RestrictionId restrictionId, RestrictionName restrictionName) {
        super("logistic.worker.restrictionadded");
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
