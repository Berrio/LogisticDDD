package com.DDD.domain.worker;

import co.com.sofka.domain.generic.Entity;
import com.DDD.domain.worker.values.RestrictionId;
import com.DDD.domain.worker.values.RestrictionName;

import java.util.Objects;

public class Restriction extends Entity<RestrictionId> {

    private RestrictionName restrictionName;

    public Restriction(RestrictionId restrictionId, RestrictionName restrictionName) {
        super(restrictionId);
        this.restrictionName = restrictionName;
    }

    public void updateRestrictionName(RestrictionName restrictionName) {
        this.restrictionName = Objects.requireNonNull(restrictionName);
    }

    public RestrictionName restrictionName() {
        return restrictionName;
    }
}
