import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class BusBookingSystem {
    private List<Bus> buses = new ArrayList<>();

    public BusBookingSystem() {
        // Sample buses
        buses.add(new Bus("118", "Millennium CC - Sohna", 50));
        buses.add(new Bus("218", "Rajiv Chauk -  Sohna", 40));
        buses.add(new Bus("111B", "Millennium CC - Vatika Chauk", 30));
        buses.add(new Bus("120", "Gurugram - IIFCO Chauk", 20));
        buses.add(new Bus("DL3", "Delhi - Gurugram", 30));
        buses.add(new Bus("HR26", "Gurugram - Kota", 30));
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Bus Booking System!");

        while (true) {
            System.out.println("1. View Buses");
            System.out.println("2. Book a Seat");
            System.out.println("3. View Seat Details");
            System.out.println("4. Exit");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    viewBuses();
                    break;
                case 2:
                    bookSeat(scanner);
                    break;
                case 3:
                    viewSeatDetails(scanner);
                    break;
                case 4:
                    System.out.println("Thank you for using the system!");
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private void viewBuses() {
        for (Bus bus : buses) {
            System.out.println("Bus Number: " + bus.getBusNumber() + ", Route: " + bus.getRoute());
        }
    }

    private void bookSeat(Scanner scanner) {
        System.out.println("Enter Bus Number:");
        String busNumber = scanner.next();
        Bus selectedBus = null;

        for (Bus bus : buses) {
            if (bus.getBusNumber().equals(busNumber)) {
                selectedBus = bus;
                break;
            }
        }

        if (selectedBus == null) {
            System.out.println("Bus not found.");
            return;
        }

        System.out.println("Enter Seat Number (0 to " + (selectedBus.getTotalSeats() - 1) + "):");
        int seatNumber = scanner.nextInt();

        System.out.println("Enter Passenger Name:");
        String passengerName = scanner.next();

        Booking booking = new Booking(selectedBus);
        if (selectedBus.isSeatAvailable(seatNumber) && booking.bookSeat(seatNumber, passengerName)) {
            System.out.println("Seat booked successfully!");
        } else {
            System.out.println("Seat is already booked or invalid.");
        }
    }

    private void viewSeatDetails(Scanner scanner) {
        System.out.println("Enter Bus Number:");
        String busNumber = scanner.next();
        Bus selectedBus = null;

        for (Bus bus : buses) {
            if (bus.getBusNumber().equals(busNumber)) {
                selectedBus = bus;
                break;
            }
        }

        if (selectedBus == null) {
            System.out.println("Bus not found.");
            return;
        }

        Map<Integer, String> seatDetails = selectedBus.getSeatDetails();
        System.out.println("Seat Details for Bus " + busNumber + ":");
        for (int i = 0; i < selectedBus.getTotalSeats(); i++) {
            String passengerName = seatDetails.getOrDefault(i, "Available");
            System.out.println("Seat " + i + ": " + passengerName);
        }
    }

    public static void main(String[] args) {
        BusBookingSystem system = new BusBookingSystem();
        system.start();
    }
}
