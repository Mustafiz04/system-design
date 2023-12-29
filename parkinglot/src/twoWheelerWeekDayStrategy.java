public class twoWheelerWeekDayStrategy implements ParkingStrategy {

    public int charge(int hours) {
        if(hours <= 1) return 10;
        return hours * 15;
    }
}
