package dev.trandafyl.int20htrandafylback.models;

import lombok.Getter;

@Getter
public enum DegreeType {
    BACHELOR("Бакалавр"),
    MASTER("Магістр"),
    PHD("Доктор філософії");

    private final String name;

    DegreeType(String name) {
        this.name = name;
    }
}
