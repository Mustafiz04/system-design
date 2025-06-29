package tictactoe;

public class Game {
    private final Board board;
    private final Player playerX;
    private final Player playerO;
    private Player currentPlayer;
    private GameStatus status;

    public Game(int boardSize, String playerXName, String playerOName) {
        this.board = new Board(boardSize);
        this.playerX = new Player(playerXName, Symbol.X);
        this.playerO = new Player(playerOName, Symbol.O);
        this.currentPlayer = playerX; // Player X starts first
        this.status = GameStatus.IN_PROGRESS;
    }

    public synchronized void playMove(int row, int col) {
        if( status != GameStatus.IN_PROGRESS ) {
            System.out.println("Game is already over. Please reset to play again.");
            return;
        }
        if( !board.isValidMove(row, col) ) {
            System.out.println("Invalid move. Try again.");
            return;
        }

        board.placeMove(row, col, currentPlayer.getSymbol());
        printBoard();
        if( board.checkWin(currentPlayer.getSymbol()) ) {
            this.status = GameStatus.valueOf(currentPlayer.getSymbol().name() + "_WINS");
            System.out.println("Congratulations " + currentPlayer.getName() + "! You win!");
        } else {
            if( board.isFull() ) {
                this.status = GameStatus.DRAW;
                System.out.println("The game is a draw.");
            } else {
                // Switch players
                currentPlayer = (currentPlayer == playerX) ? playerO : playerX;
                System.out.println("Next turn: " + currentPlayer.getName());
            }
        }
    }

    public synchronized void reset() {
        this.board.reset();
        this.currentPlayer = playerX;
        this.status = GameStatus.IN_PROGRESS;
    }

    public void printBoard() {
        board.printBoard();
    }
}
