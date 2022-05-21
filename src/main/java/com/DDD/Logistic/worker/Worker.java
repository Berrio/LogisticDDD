package com.DDD.Logistic.worker;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import com.DDD.Logistic.system.values.*;
import com.DDD.Logistic.worker.events.*;
import com.DDD.Logistic.worker.values.*;
import com.DDD.Logistic.worker.values.WorkerId;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public class Worker extends AggregateEvent<WorkerId> {

    private WorkerId workerId;
    private WorkerName workerName;
    private Set<Restriction> restrictions;
    private Set<Function> functions;
    private Set<Area> areas;

    public Worker(WorkerId workerId,WorkerName workerName, Set<Restriction> restrictions , Set<Function> functions, Set<Area> areas) {
        super(workerId);
        this.workerId = workerId;
        this.workerName=workerName;
        this.restrictions = restrictions;
        this.functions =functions ;
        this.areas = areas;
    }

    private Worker(WorkerId workerId){
        super(workerId);
        subscribe(new WorkerChanged(this));
    }

    public static Worker from(WorkerId personId, List<DomainEvent> events) {
        var worker = new Worker(personId);
        events.forEach(worker::applyEvent);
        return worker;
    }

    public void associateSystem(SystemId systemId) {
        appendChange(new SystemAssociated(systemId)).apply();
    }

    public void addRestiction(RestrictionId restrictionId, RestrictionName restrictionName){
        Objects.requireNonNull(restrictionId);
        Objects.requireNonNull(restrictionName);
        appendChange(new RestrictionAdded(restrictionId,restrictionName)).apply();
    }

    public void addFunction(FunctionId functionId, FunctionName functionName){
        Objects.requireNonNull(functionId);
        Objects.requireNonNull(functionName);
        appendChange(new FunctionAdded(functionId,functionName)).apply();
    }

    public void addArea(AreaId areaId, Area area){
        Objects.requireNonNull(areaId);
        Objects.requireNonNull(area);
        appendChange(new AreaAdded(areaId,area)).apply();
    }

    public void updateAreaName(AreaId areaId, Area area){
        appendChange(new AreaNameUpdated(areaId, area)).apply();
    }

    public void updateFunctionName(FunctionId functionId, FunctionName functionName){
        appendChange(new FunctionNameUpdated(functionId, functionName)).apply();
    }

    public void updateRestrictionName(RestrictionId restrictionId, RestrictionName restrictionName){
        appendChange(new RestrictionNameUpdated(restrictionId, restrictionName)).apply();
    }

    protected Optional<Restriction> getRestrictionById(RestrictionId entityId) {
        return restrictions()
                .stream()
                .filter(restriction -> restriction.identity().equals(entityId))
                .findFirst();
    }

    protected Optional<Function> getFunctionById(FunctionId entityId) {
        return functions()
                .stream()
                .filter(function -> function.identity().equals(entityId))
                .findFirst();
    }

    protected Optional<Area> getAreaById(AreaId entityId) {
        return areas()
                .stream()
                .filter(area -> area.identity().equals(entityId))
                .findFirst();
    }

    public WorkerId workerId() {
        return workerId;
    }

    public Set<Restriction> restrictions() {
        return restrictions;
    }

    public Set<Function> functions() {
        return functions;
    }

    public Set<Area> areas() {
        return areas;
    }
}
