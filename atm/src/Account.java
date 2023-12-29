public class Account {
    private String accountNumber;
    private int availableMoney;

    public Account(String accountNumber, int availableMoney) {
        this.accountNumber = accountNumber;
        this.availableMoney = availableMoney;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setAvailableMoney(int availableMoney) {
        this.availableMoney = availableMoney;
    }
}
