import java.util.*;

public class Main {
    public static void main(String[] args) {
        Map<Integer, Integer> snakes = new HashMap<>();
        snakes.put(17, 7);
        snakes.put(54, 34);
        snakes.put(62, 19);
        snakes.put(98, 19);

        Map<Integer, Integer> ladders = new HashMap<>();
        ladders.put(3, 38);
        ladders.put(24, 33);
        ladders.put(42, 93);
        ladders.put(72, 84);

        Board snakesAndLaddersBoard = new Board(100, snakes, ladders);
        Player player1 = new Player("Mustafiz", 1);
        Player player2 = new Player("Kaifee", 2);
        Player player3 = new Player("Mumtaz", 3);
        Player[] playersArray = {player1, player2, player3};

        Game snakeAndLadderGame = new Game(playersArray, snakesAndLaddersBoard);

        while (!snakeAndLadderGame.isWinner()) {
            snakeAndLadderGame.makeMove();
        }
    }
}