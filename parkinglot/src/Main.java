// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws ParkingFullException, InvalidVehicleNumberException {
        ParkingLot parkingLot = ParkingLot.getParkingLot();
        parkingLot.initializeParkingSlots(10, 10);
        Vehicle bike = new Vehicle("KA3211", VehicleType.TWO_WHEELER);
        Ticket ticket = parkingLot.park(bike);
        System.out.println(ticket);

        Vehicle car = new Vehicle("KA3212341", VehicleType.FOUR_WHEELER);
        Ticket ticket1 = parkingLot.park(bike);
        System.out.println(ticket1);

        int charge = parkingLot.unpark(ticket, new twoWheelerWeekDayStrategy());
        System.out.println(charge);
    }
}