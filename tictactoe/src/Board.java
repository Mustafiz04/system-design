public class Board {
    Cell[][] board;
    private final int size;
    Board(int size) {
        this.size = size;
        board = new Cell[size][size];
        initializeBoard();
    }

    public void initializeBoard() {
        for(int i = 0; i<size; i++) {
            for(int j = 0; j<size; j++) {
                board[i][j] = new Cell(i, j);
            }
        }
        System.out.println("GAME STARTED");
        printBoard();
    }

    public void printBoard() {
        for(int i = 0; i<size; i++) {
            for(int j = 0; j<size; j++) {
                if(board[i][j].getPiece() == null) {
                    System.out.print(" | " + " " + " | ");
                } else {
                    System.out.print(" | " + board[i][j].getPiece() + " | ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public Cell[][] getBoard() {
        return board;
    }

    public void setBoard(Cell[][] board) {
        this.board = board;
    }

    public int getSize() {
        return size;
    }
}
