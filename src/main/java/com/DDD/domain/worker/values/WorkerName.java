package com.DDD.domain.worker.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class WorkerName implements ValueObject<String> {

    private String value;

    public WorkerName(String value) {

        this.value = Objects.requireNonNull(value);
        if (value.isBlank()) {
            throw new IllegalArgumentException("The  Worker Name can't be blank");
        }
        if (value.length() > 15) {
            throw new IllegalArgumentException("The  Worker Name can't be too long");
        }
        if (value.length() < 4) {
            throw new IllegalArgumentException("The  Worker Name can't be too short");
        }
    }

    @Override
    public String value() {
        return value;
    }


}
