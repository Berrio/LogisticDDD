package com.DDD.Logistic.system.values;

import co.com.sofka.domain.generic.ValueObject;

public class Stowage implements ValueObject<String> {

    private String value;

    @Override
    public String value() {
        return value;
    }

}
