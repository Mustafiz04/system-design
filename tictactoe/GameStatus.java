package tictactoe;

public enum GameStatus {
    IN_PROGRESS,
    X_WINS,
    O_WINS,
    DRAW;

    @Override
    public String toString() {
        switch (this) {
            case IN_PROGRESS:
                return "Game is still in progress.";
            case X_WINS:
                return "Player X wins!";
            case O_WINS:
                return "Player O wins!";
            case DRAW:
                return "The game is a draw.";
            default:
                return "Unknown game status.";
        }
    }
}
