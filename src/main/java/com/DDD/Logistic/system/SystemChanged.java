package com.DDD.Logistic.system;

import co.com.sofka.domain.generic.EventChange;
import com.DDD.Logistic.system.events.SystemCreated;

import java.util.HashSet;

public class SystemChanged extends EventChange {
    public SystemChanged(System system) {

        apply((SystemCreated event)->{
            system.systemName=event.getSystemName();
            system.positions=new HashSet<>();
            system.products=new HashSet<>();
            system.observations=new HashSet<>();
        });

        apply((SystemCreated event)->{
            system.systemName=event.getSystemName();
            system.positions=new HashSet<>();
            system.products=new HashSet<>();
            system.observations=new HashSet<>();
        });

    }
}
