package com.DDD.domain.system.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Stowage implements ValueObject<String> {

    private String value;

    @Override
    public String value() {
        return value;
    }

    public Stowage(String value) {

        this.value = Objects.requireNonNull(value);
        if (value.isBlank()) {
            throw new IllegalArgumentException("The  Name can't be blank");
        }
        if (value.length() > 15) {
            throw new IllegalArgumentException("The  Name can't be too long");
        }
        if (value.length() < 4) {
            throw new IllegalArgumentException("The  Name can't be too short");
        }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Stowage stowage = (Stowage) o;
        return Objects.equals(value, stowage.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
