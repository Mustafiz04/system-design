package creational.singleton;

public class President {
    private String name;
    private String partyName;
    private static President instance;

    public static President getInstance() {
        if( instance == null ) {
            instance = new President();
        }
        return instance;
    }

    public String getName() {
        return name;
    }

    public String getPartyName() {
        return partyName;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Example getter method:
    public void setPartyName(String name) {
        this.partyName = name;
    }

}
