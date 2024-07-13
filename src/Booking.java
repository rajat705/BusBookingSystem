import java.util.ArrayList;
import java.util.List;

public class Booking {
    private Bus bus;
    private List<Passenger> passengers = new ArrayList<>();

    public Booking(Bus bus) {
        this.bus = bus;
    }

    public boolean bookSeat(int seatNumber, String passengerName) {
        if (bus.isSeatAvailable(seatNumber)) {
            String ticketId = generateTicketId(passengerName);
            passengers.add(new Passenger(passengerName, ticketId));
            bus.bookSeat(seatNumber, passengerName);
            return true;
        }
        return false;
    }

    private String generateTicketId(String name) {
        return name.substring(0, 2) + System.currentTimeMillis(); // Simple ID generation
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }
}
