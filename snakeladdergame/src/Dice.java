import java.util.Random;

public class Dice {
    private int numberOfDice;
    Dice(int numberOfDice) {
        this.numberOfDice = numberOfDice;
    }
    public int roll() {
        return new Random().nextInt(6*numberOfDice - 1*numberOfDice) + 1;
    }
}
