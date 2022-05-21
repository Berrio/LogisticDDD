package com.DDD.domain.system.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class SystemName implements ValueObject<String> {

    private String value;

    public SystemName(String value) {

        this.value = Objects.requireNonNull(value);
        if (value.isBlank()) {
            throw new IllegalArgumentException("The System Name can't be blank");
        }
        if (value.length() > 15) {
            throw new IllegalArgumentException("The System Name can't be too long");
        }
        if (value.length() < 4) {
            throw new IllegalArgumentException("The System Name can't be too short");
        }

    }

    @Override
    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SystemName that = (SystemName) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
