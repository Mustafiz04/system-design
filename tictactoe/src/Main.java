
public class Main {
    public static void main(String[] args) {
        Player p1 = new Player("Mustafiz", "123", Piece.X);
        Player p2 = new Player("Kaifee", "321", Piece.O);

        Game game = new Game(p1, p2);
        game.play(0, 0);
        game.play(0, 1);
        game.play(0, 2);
        game.play(1, 1);
        game.play(1, 0);
        game.play(1, 2);
        game.play(2, 0);
//        game.play(2, 1);
//        game.play(2, 2);
//        game.play(2, 2);
    }
}