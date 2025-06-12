public enum Denomination {
    ONE(1),
    TWO(2),
    FIVE(5),
    TEN(10),
    FIFTY(50),
    HUNDRED(100);

    public final int value;

    Denomination(int value) {
        this.value = value;
    }

    int getValue() {
        return this.value;
    }
}
