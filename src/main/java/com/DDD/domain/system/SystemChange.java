package com.DDD.domain.system;

import co.com.sofka.domain.generic.EventChange;
import com.DDD.domain.system.events.*;

import java.util.HashSet;

public class SystemChange extends EventChange {
    public SystemChange(System system) {

        apply((SystemCreate event)->{
            system.systemName=event.getSystemName();
            system.positions=new HashSet<>();
            system.products=new HashSet<>();
            system.observations=new HashSet<>();
        });

        apply((ProductAreaUpdated event)->{
            var product=system.getProductById(event.getProductId()).
                    orElseThrow(()-> new IllegalArgumentException("Product not found"));
            product.updateArea(event.getProductArea());
        });

        apply((ProductAdded event)->{
            system.products.add(new Product(
                    event.productId(),
                    event.area()
            ));
        });

        apply((PositionStowageUpdated event)->{
            var position=system.getPositionById(event.getPositionId()).
                    orElseThrow(()-> new IllegalArgumentException("Position not found"));
            position.updateStowage(event.getStowage());
        });

        apply((PositionAdded event)->{
            system.positions.add(new Position(
                    event.getPositionId(),
                    event.getStowage()
            ));
        });

        apply((DescriptionUpdated event)->{
            var desc=system.getObservationById(event.getObservationId()).
                    orElseThrow(()-> new IllegalArgumentException("Observation not found"));
            desc.updateStowage(event.getDescription());
        });

        apply((ObservationAdded event)->{
            system.observations.add(new Observation(
                    event.getObservationId(),
                    event.getDescription()
            ));
        });

    }
}
