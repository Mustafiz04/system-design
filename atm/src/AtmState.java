public interface AtmState {
    public AtmState readInsertedCard();
    public AtmState authenticatePin();
}