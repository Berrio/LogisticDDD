package com.DDD.Logistic.worker.values;

import co.com.sofka.domain.generic.ValueObject;

public class RestrictionName implements ValueObject<String> {

    private String value;

    @Override
    public String value() {
        return value;
    }

}
