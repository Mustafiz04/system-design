public class Game {
    private Dice dice;
    private final Board board;
    private Player[] players;
    private int currPlayerIndex;

    public Game(Player[] players, Board board) {
        this.dice = new Dice(1);
        this.board = board;
        this.players = players;
        this.currPlayerIndex = 0;
    }

    public void makeMove() {
        int rollValue = dice.roll();
        System.out.println("Player " + (currPlayerIndex + 1) + " " + players[currPlayerIndex].getPlayerName() + " rolled a " + rollValue);
        if( players[currPlayerIndex].getPosition() + rollValue <= board.getSize() ) {
            players[currPlayerIndex].setPosition(players[currPlayerIndex].getPosition() + rollValue);
            checkForSnackOrLadder();

            System.out.println("Player " + (currPlayerIndex + 1) + " is now at position " + players[currPlayerIndex].getPosition());

        } else {
            System.out.println("Player " + (currPlayerIndex + 1) + " is now at position " + players[currPlayerIndex].getPosition() + " can't move to further as it is out of bound.");
        }
        if(!isWinner()) {
            switchPlayer();
        }
    }

    void checkForSnackOrLadder() {
        int position = players[currPlayerIndex].getPosition();
        if( board.getSnakes().containsKey(position) ) {
            System.out.println("Oops! Snake bite! Going down to " + board.getSnakes().get(position));
            players[currPlayerIndex].setPosition(board.getSnakes().get(position));
        } else if(  board.getLadders().containsKey(position) ) {
            System.out.println("Yay! Climbing the ladder to " + board.getLadders().get(position));
            players[currPlayerIndex].setPosition(board.getLadders().get(position));
        }
    }

    public boolean isWinner() {
        if(players[currPlayerIndex].getPosition() == board.getSize()) {
            System.out.println(players[currPlayerIndex].getPlayerName());
            return true;
        }
        return false;
    }

    public void switchPlayer() {
        currPlayerIndex = (currPlayerIndex + 1 ) % players.length;
    }
}
