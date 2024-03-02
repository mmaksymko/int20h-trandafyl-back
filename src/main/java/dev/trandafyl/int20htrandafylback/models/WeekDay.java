package dev.trandafyl.int20htrandafylback.models;

import lombok.Getter;

@Getter
public enum WeekDay {
    MONDAY("Понеділок"),
    TUESDAY("Вівторок"),
    WEDNESDAY("Середа"),
    THURSDAY("Четвер"),
    FRIDAY("П'ятниця"),
    SATURDAY("Субота"),
    SUNDAY("Неділя");

    private final String name;

    WeekDay(String name) {
        this.name = name;
    }
}
