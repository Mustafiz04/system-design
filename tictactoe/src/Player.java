public class Player extends User {
    private Piece piece;
    Player(String username, String userid, Piece piece) {
        super(username, userid);
        this.piece = piece;
    }

    public Piece getPiece() {
        return this.piece;
    }
}
