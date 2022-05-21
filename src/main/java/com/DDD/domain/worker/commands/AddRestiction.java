package com.DDD.domain.worker.commands;

import co.com.sofka.domain.generic.Command;
import com.DDD.domain.worker.values.RestrictionId;
import com.DDD.domain.worker.values.RestrictionName;
import com.DDD.domain.worker.values.WorkerId;

public class AddRestiction extends Command {

    private final WorkerId workerId;
    private final RestrictionId restrictionId;
    private final RestrictionName restrictionName;

    public AddRestiction(WorkerId workerId, RestrictionId restrictionId, RestrictionName restrictionName) {
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
