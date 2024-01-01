
public class Player {
    private int id;
    private String playerName;
    private int position;
    private boolean isWinner;

    Player(String playerName, int id) {
        this.playerName = playerName;
        this.position = 0;
        this.isWinner = false;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public boolean isWinner() {
        return isWinner;
    }

    public void setWinner(boolean winner) {
        isWinner = winner;
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
