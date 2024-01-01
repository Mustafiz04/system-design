public class Game {
    private final Board board;
    private final Player[] players;
    private Status status;
    private Player currPlayer;
    private final int numberOfPlayer = 2;
    private final int numberOfCell = 3;
    private int totalMove  = 0;

    public Game(Player p1, Player p2) {
        this.board = new Board(numberOfCell);
        this.players = new Player[numberOfPlayer];
        this.players[0] = p1;
        this.players[1] = p2;
        this.currPlayer = p1;
        this.status = Status.PLAYING;
    }

    public Status getGameStatus() {
        return this.status;
    }

    public void SetGameStatus(Status status) {
        this.status = status;
    }

    public boolean isWinner() {
        return false;
    }

    public void changePlayerTurn() {
        if(currPlayer.getUserId().equals(players[0].getUserId())) {
            this.currPlayer = players[1];
        } else {
            this.currPlayer = players[0];
        }
    }

    private boolean isValidMove(int row, int col) {
        return row < numberOfCell && col < numberOfCell && board.getBoard()[row][col] != null;
    }

    public boolean play(int row, int col) {
        if (status.PLAYING == status) {
            if (isValidMove(row, col)) {
                board.getBoard()[row][col].setPiece(currPlayer.getPiece());
                totalMove++;
                if (checkIfWon(row, col)) {
                    System.out.println(currPlayer.getUsername() + " has won the Game!!");
                    status = Status.WON;
                    board.printBoard();
                    return false;
                } else if (totalMove == numberOfCell * numberOfCell) {
                    System.out.println("Game has been finished with status DRAW!!");
                    status = Status.DRAW;
                    board.printBoard();
                    return false;
                }
                status = Status.PLAYING;
                changePlayerTurn();
                board.printBoard();
                return true;
            }
            System.out.println(currPlayer.getUsername() + " Please put valid move!");
            board.printBoard();
            return false;
        } else {
            System.out.println(currPlayer.getUsername() + " has already won the game! GAME IS OVER");
            board.printBoard();
            return false;
        }
    }

    private boolean checkIfDraw(int row, int col) {

//        if (drl > numberOfCell || dlr > numberOfCell || arrCol[col] > numberOfCell || arrRow[row] > numberOfCell
//                || -numberOfCell > arrRow[row] || drl < -numberOfCell || dlr < -numberOfCell || arrCol[col] < -numberOfCell) {
//
//            status = Status.DRAW;
//            System.out.println("Game has been finished with status DRAW!!");
//            return true;
//        }
        return false;
    }

    private boolean checkIfWon(int row, int col) {
        boolean rowMatch = true;
        boolean colMatch = true;
        boolean diagonalMatch = true;
        boolean antiDiagonalMatch = true;

        for(int i = 0; i < board.getSize(); i++) {
            if( board.getBoard()[row][i] != null && board.getBoard()[row][i].getPiece() != currPlayer.getPiece() ) {
                rowMatch = false;
            }
        }

        for(int i = 0; i < board.getSize(); i++) {
            if( board.getBoard()[i][col] != null && board.getBoard()[i][col].getPiece() != currPlayer.getPiece() ) {
                colMatch = false;
            }
        }

        for(int i = 0, j = 0; i < board.getSize(); i++, j++) {
            if( board.getBoard()[i][j] != null && board.getBoard()[i][j].getPiece() != currPlayer.getPiece() ) {
                diagonalMatch = false;
            }
        }

        for(int i = 0, j = board.getSize() - 1; i < board.getSize(); i++, j--) {
            if( board.getBoard()[i][j] != null && board.getBoard()[i][j].getPiece() != currPlayer.getPiece() ) {
                antiDiagonalMatch = false;
            }
        }

        return rowMatch || colMatch || diagonalMatch || antiDiagonalMatch;
    }
}
