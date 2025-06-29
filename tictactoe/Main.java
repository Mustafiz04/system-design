package tictactoe;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to Tic Tac Toe!");

        Game game = new Game(3, "X", "O");
        game.printBoard();

        game.playMove(2, 0); // Player X
        game.playMove(1, 1); // Player O
        game.playMove(0, 2); // Player X
        game.playMove(2, 1); // Player O
        game.playMove(1, 2); // Player X
        game.playMove(1, 0); // Player O
        game.playMove(0, 0); // Player X
        game.playMove(0, 1); // Player O

    }
}
//[[2,0],[1,1],[0,2],[2,1],[1,2],[1,0],[0,0],[0,1]]
