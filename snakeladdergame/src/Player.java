
public class Player {
    private String playerName;
    private int position;
    private boolean isWinner;

    Player(String playerName) {
        this.playerName = playerName;
        this.position = 0;
        this.isWinner = false;
    }

    public String getPlayerName () {
        return this.playerName;
    }

    int getPosition() {
        return this.position;
    }

    void setPosition(int position) {
        this.position = position;
    }
}
