package com.DDD.Logistic.worker;

import co.com.sofka.domain.generic.EventChange;
import com.DDD.Logistic.worker.events.*;

import java.util.HashSet;

public class WorkerChanged extends EventChange {
    public WorkerChanged(Worker worker) {

        apply((WorkerCreated event)->{
            worker.workerName= event.getWorkerName();
            worker.restrictions= new HashSet<>();
            worker.functions= new HashSet<>();
            worker.areas= new HashSet<>();
        });

        apply((SystemAssociated event)->{
            worker.systemId=event.getSystemId();
        });

        apply((RestrictionNameUpdated event)->{
            var restriction=worker.getRestrictionById(event.restrictionId()).
                    orElseThrow(()-> new IllegalArgumentException("Restriction not found"));
            restriction.updateRestrictionName(event.restrictionName());
        });

        apply((RestrictionAdded event)->{
            worker.restrictions.add(new Restriction(
                    event.restrictionId(),
                    event.restrictionName()
                    ));
        });

        apply((FunctionNameUpdated event)->{
            var function=worker.getFunctionById(event.getFunctionId()).
                    orElseThrow(()-> new IllegalArgumentException("Function not found"));
            function.updateFunctionName(event.getFunctionName());
        });

        apply((FunctionAdded event)->{
            worker.functions.add(new Function(
                    event.functionId(),
                    event.functionName()
            ));
        });

        apply((AreaNameUpdated event)->{
            var areaUpdate=worker.getAreaById(event.getAreaId()).
                    orElseThrow(()-> new IllegalArgumentException("Area not found"));
            areaUpdate.updateArea(event.getArea());
        });

        apply((AreaAdded event)->{
            worker.areas.add(new Area(
                    event.areaId(),
                    event.area()
            ));
        });
    }
}
