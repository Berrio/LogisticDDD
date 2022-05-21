package com.DDD.Logistic.worker.commands;

import co.com.sofka.domain.generic.Command;
import com.DDD.Logistic.worker.values.RestrictionId;
import com.DDD.Logistic.worker.values.RestrictionName;
import com.DDD.Logistic.worker.values.WorkerId;

public class UpdateRestrictionName extends Command {

    private final WorkerId workerId;
    private final RestrictionId restrictionId;
    private final RestrictionName restrictionName;

    public UpdateRestrictionName(WorkerId workerId, RestrictionId restrictionId, RestrictionName restrictionName) {
        this.workerId = workerId;
        this.restrictionId = restrictionId;
        this.restrictionName = restrictionName;
    }

    public WorkerId getWorkerId() {
        return workerId;
    }

    public RestrictionId getRestrictionId() {
        return restrictionId;
    }

    public RestrictionName getRestrictionName() {
        return restrictionName;
    }
}
