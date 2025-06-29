package tictactoe;

public class Cell {
    private Symbol symbol;
    private boolean isOccupied;

    public Cell() {
        this.symbol = Symbol.EMPTY;
        this.isOccupied = false;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
        this.isOccupied = true;
    }

    public boolean isOccupied() {
        return isOccupied;
    }
}
