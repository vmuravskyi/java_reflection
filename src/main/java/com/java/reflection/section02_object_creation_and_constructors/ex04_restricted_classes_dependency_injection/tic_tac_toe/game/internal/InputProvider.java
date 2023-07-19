package com.java.reflection.section02_object_creation_and_constructors.ex04_restricted_classes_dependency_injection.tic_tac_toe.game.internal;

interface InputProvider {
    BoardLocation provideNextMove(Board board);
}
