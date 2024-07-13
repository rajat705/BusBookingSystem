import java.util.HashMap;
import java.util.Map;

public class Bus {
    private String busNumber;
    private String route;
    private boolean[] seats; // true if booked, false if available
    private Map<Integer, String> seatMap; // seat number to passenger name mapping

    public Bus(String busNumber, String route, int totalSeats) {
        this.busNumber = busNumber;
        this.route = route;
        this.seats = new boolean[totalSeats];
        this.seatMap = new HashMap<>();
    }

    public String getBusNumber() {
        return busNumber;
    }

    public String getRoute() {
        return route;
    }

    public boolean isSeatAvailable(int seatNumber) {
        return !seats[seatNumber];
    }

    public void bookSeat(int seatNumber, String passengerName) {
        seats[seatNumber] = true;
        seatMap.put(seatNumber, passengerName);
    }

    public int getTotalSeats() {
        return seats.length;
    }

    public Map<Integer, String> getSeatDetails() {
        return seatMap;
    }
}
