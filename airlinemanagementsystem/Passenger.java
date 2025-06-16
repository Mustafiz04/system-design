package airlinemanagementsystem;

import java.util.UUID;

public class Passenger {
    private final String id;
    private final String name;
    private final String passportNumber;
    private final String email;

    public Passenger(String name, String passportNumber, String email) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.passportNumber = passportNumber;
        this.email = email;
    }

    // Getter
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public String getEmail() {
        return email;
    }
}
