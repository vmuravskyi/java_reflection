package com.java.reflection.section02_object_creation_and_constructors.ex04_restricted_classes_dependency_injection.tic_tac_toe.game.internal;

class ComputerPlayer implements Player {
    private static final String NAME = "Computer";
    private final ComputerInputProvider locationProvider;

    public ComputerPlayer(ComputerInputProvider locationProvider) {
        this.locationProvider = locationProvider;
    }

    @Override
    public void play(Board board, Sign sign) {
        BoardLocation location = locationProvider.provideNextMove(board);
        board.updateCell(location.getRow(), location.getColumn(), sign);
    }

    @Override
    public String getPlayerName() {
        return NAME;
    }
}
