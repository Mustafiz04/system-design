class Building {
    private int buildingId;
    private int numFloors;

    public Building(int buildingId, int numFloors) {
        this.buildingId = buildingId;
        this.numFloors = numFloors;
    }

    public int getBuildingId() {
        return buildingId;
    }

    public int getNumFloors() {
        return numFloors;
    }
}