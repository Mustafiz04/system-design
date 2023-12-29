public class ReadInsertedCard implements AtmState{


    @Override
    public AtmState readInsertedCard() {
        return new AuthenticatePin();
    }

    @Override
    public AtmState authenticatePin() {
        return null;
    }
}
