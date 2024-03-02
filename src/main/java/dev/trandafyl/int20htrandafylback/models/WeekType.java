package dev.trandafyl.int20htrandafylback.models;

import lombok.Getter;

@Getter
public enum WeekType {
    NUMERATOR(1),
    DENOMINATOR(0),
    BOTH(2);

    private final int name;

    WeekType(int name) {
        this.name = name;
    }
}
