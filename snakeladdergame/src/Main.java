import java.util.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Map<Integer, Integer> snakes = new HashMap<>();
        snakes.put(17, 7);
        snakes.put(54, 34);
        snakes.put(62, 19);
        snakes.put(98, 79);

        Map<Integer, Integer> ladders = new HashMap<>();
        ladders.put(3, 38);
        ladders.put(24, 33);
        ladders.put(42, 93);
        ladders.put(72, 84);

        Board snakesAndLaddersBoard = new Board(50, snakes, ladders);
        Player player1 = new Player("Mustafiz");
        Player player2 = new Player("Kaifee");
        Player[] playersArray = {player1, player2};

        Game snakeAndLadderGame = new Game(playersArray, snakesAndLaddersBoard);

        while (!snakeAndLadderGame.isWinner()) {
            snakeAndLadderGame.makeMove();
        }
    }
}