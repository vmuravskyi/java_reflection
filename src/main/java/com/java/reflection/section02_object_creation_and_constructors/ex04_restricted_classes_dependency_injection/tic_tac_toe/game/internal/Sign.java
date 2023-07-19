package com.java.reflection.section02_object_creation_and_constructors.ex04_restricted_classes_dependency_injection.tic_tac_toe.game.internal;

enum Sign {
    EMPTY(' '),
    X('X'),
    Y('Y');

    private char value;

    Sign(char value) {
        this.value = value;
    }

    public char getValue() {
        return this.value;
    }
}
