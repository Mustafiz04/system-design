public class twoWheelerWeekendStrategy implements ParkingStrategy {

    public int charge(int hours) {
        if( hours <= 1 ) return 15;
        return hours * 20;
    }
}
