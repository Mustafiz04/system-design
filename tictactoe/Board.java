package tictactoe;

public class Board {
    private final Cell[][] cells;
    private final int size;
    private int moveCount = 0;

    public Board(int size) {
        this.size = size;
        this.cells = new Cell[size][size];
        this.moveCount = 0;
        initializeBoard();
    }

    private void initializeBoard() {
        for(int i = 0; i<this.size; i++) {
            for(int j = 0; j<this.size; j++) {
                this.cells[i][j] = new Cell();
            }
        }
    }

    public boolean isValidMove(int row, int col) {
        return row >= 0 && row < this.size && col >= 0 && col < this.size && this.cells[row][col].getSymbol() == Symbol.EMPTY;
    }

    public void placeMove(int row, int col, Symbol symbol) {
        if( this.cells[row][col].isOccupied() ) {
            throw new IllegalArgumentException("Cell is already occupied.");
        }
        this.cells[row][col].setSymbol(symbol);
        moveCount++;
    }

    public boolean checkWin(Symbol symbol) {
        // row
        for(int i = 0; i<this.size; i++) {
            boolean win = true;
            for(int j = 0; j<this.size; j++) {
                if(this.cells[i][j].getSymbol() != symbol) {
                    win = false;
                    break;
                }
            }
            if(win) return true;
        }

        // col;
        for(int j = 0; j<this.size; j++) {
            boolean win = true;
            for(int i = 0; i<this.size; i++) {
                if( this.cells[i][j].getSymbol() != symbol ) {
                    win = false;
                    break;
                }
            }
            if(win) return true;
        }

        // diagonal
        boolean rightDiagonalWin = true, leftDiagonalWin = true;
        for(int i = 0; i<this.size; i++) {
            if( this.cells[i][i].getSymbol() != symbol ) {
                rightDiagonalWin = false;
            }
            if( this.cells[i][this.size - i - 1].getSymbol() != symbol ) {
                leftDiagonalWin = false;
            }
        }
        return rightDiagonalWin || leftDiagonalWin;
    }

    public boolean isFull() {
        return moveCount == size * size;
    }

    public void reset() {
        initializeBoard();
    }

    public void printBoard() {
        for(int i = 0; i<this.size; i++) {
            for(int j = 0; j<this.size; j++) {
                System.out.print(this.cells[i][j].getSymbol() + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
