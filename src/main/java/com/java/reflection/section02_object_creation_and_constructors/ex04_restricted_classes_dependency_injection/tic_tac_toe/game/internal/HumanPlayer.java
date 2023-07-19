package com.java.reflection.section02_object_creation_and_constructors.ex04_restricted_classes_dependency_injection.tic_tac_toe.game.internal;

class HumanPlayer implements Player {
    private static final String NAME = "You";
    private final KeyboardInputProvider inputProvider;

    public HumanPlayer(KeyboardInputProvider inputProvider) {
        this.inputProvider = inputProvider;
    }

    @Override
    public void play(Board board, Sign sign) {
        BoardLocation nextMoveLocation = inputProvider.provideNextMove(board);
        board.updateCell(nextMoveLocation.getRow(), nextMoveLocation.getColumn(), sign);
    }

    @Override
    public String getPlayerName() {
        return NAME;
    }
}
