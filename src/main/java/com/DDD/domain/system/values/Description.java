package com.DDD.domain.system.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Description implements ValueObject<String> {

    private String value;

    @Override
    public String value() {
        return value;
    }

    public Description(String value) {

        this.value = Objects.requireNonNull(value);
        if (value.isBlank()) {
            throw new IllegalArgumentException("The  Description can't be blank");
        }
        if (value.length() > 100) {
            throw new IllegalArgumentException("The  Description can't be too long");
        }
        if (value.length() < 5) {
            throw new IllegalArgumentException("The  Description can't be too short");
        }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Description that = (Description) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
