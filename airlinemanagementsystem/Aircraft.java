package airlinemanagementsystem;

import java.util.UUID;

public class Aircraft {
    private final String id;
    private final String model;
    private final int totalSeat;

    public Aircraft(String model, int totalSeat) {
        this.id = UUID.randomUUID().toString();
        this.model = model;
        this.totalSeat = totalSeat;
    }

    // Getters
    public String getId() {
        return id;
    }

    public String getModel() {
        return model;
    }

    public int getTotalSeat() {
        return totalSeat;
    }
}
