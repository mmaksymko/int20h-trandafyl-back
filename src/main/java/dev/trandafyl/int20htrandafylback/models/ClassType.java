package dev.trandafyl.int20htrandafylback.models;

public enum ClassType {
    LECTURE("Лекція"),
    PRACTICE("Практика"),
    LAB("Лабораторна");

    private final String name;

    ClassType(String name) {
        this.name = name;
    }
}
