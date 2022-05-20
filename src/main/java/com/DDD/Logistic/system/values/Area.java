package com.DDD.Logistic.system.values;


import co.com.sofka.domain.generic.Identity;
import co.com.sofka.domain.generic.ValueObject;

public class Area implements ValueObject<String> {

    private String value;

    @Override
    public String value() {
        return value;
    }

}
