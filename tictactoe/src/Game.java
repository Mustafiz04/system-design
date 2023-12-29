public class Game {
    private final Board board;
    private final Player[] players;
    private Status status;
    private Player currPlayer;
    private final int numberOfPlayer = 2;
    private final int numberOfCell = 3;
    private final int[] arrRow = new int[numberOfCell];
    private final int[] arrCol = new int[numberOfCell];
    int dlr = 0;
    int drl = 0;


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
                if (checkIfWon(row, col)) {
                    board.printBoard();
                    return false;
                } else if (checkIfDraw(row, col)) {
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
        if (drl > numberOfCell || dlr > numberOfCell || arrCol[col] > numberOfCell || arrRow[row] > numberOfCell
                || -numberOfCell > arrRow[row] || drl < -numberOfCell || dlr < -numberOfCell || arrCol[col] < -numberOfCell) {

            status = Status.DRAW;
            System.out.println("Game has been finished with status DRAW!!");
            return true;
        }
        return false;
    }

    private boolean checkIfWon(int row, int col) {

        if (currPlayer.getUserId().equals(players[0].getUserId())) {
            if (row == col) {
                dlr++;
            } else if (row + col == numberOfCell - 1) {
                drl++;
            }
            arrRow[row] = arrRow[row] + 1;
            arrCol[col] = arrCol[col] + 1;
            if (arrRow[row] == numberOfCell || arrCol[col] == numberOfCell || drl == numberOfCell || dlr == numberOfCell) {
                status = Status.WON;
                System.out.println(currPlayer.getUsername() + " has won the Game!!");
                return true;
            }
        } else {
            if (row == col) {
                dlr--;
            } else if (row + col == -(numberOfCell - 1)) {
                drl--;
            }
            arrRow[row] = arrRow[row] - 1;
            arrCol[col] = arrCol[col] - 1;
            if (arrRow[row] == -numberOfCell || arrCol[col] == -numberOfCell || drl == -numberOfCell || dlr == -numberOfCell) {
                status = Status.WON;
                System.out.println(currPlayer.getUsername() + " has won the Game!!");
                return true;
            }

        }

        return false;
    }

}
