package com.java.reflection.section02_object_creation_and_constructors.ex04_restricted_classes_dependency_injection.tic_tac_toe.game.internal;

class BoardDimensions {
    private static final int NUM_OF_ROWS = 3;
    private static final int NUM_OF_COLUMNS = 3;


    public int getNumberOfRows() {
        return NUM_OF_ROWS;
    }

    public int getNumberOfColumns() {
        return NUM_OF_COLUMNS;
    }
}
