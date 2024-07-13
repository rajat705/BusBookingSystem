public class Passenger {
    private String name;
    private String ticketId;

    public Passenger(String name, String ticketId) {
        this.name = name;
        this.ticketId = ticketId;
    }

    public String getName() {
        return name;
    }

    public String getTicketId() {
        return ticketId;
    }
}
