public class Card {
    private String cardNumber;
    private int pin;

    public Card(String cardNumber, int pin) {
        this.cardNumber = cardNumber;
        this.pin = pin;
    }

    public boolean validatePin(int pin) {
        return this.pin == pin;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }
}
