package school.siit;

public class FestivalAttendeeThread implements Runnable, Comparable<FestivalAttendeeThread>{
    private TicketType ticketType;
    private FestivalGate gate;

    public FestivalAttendeeThread(TicketType ticketType, FestivalGate gate) {
        this.ticketType = ticketType;
        this.gate = gate;
    }

    @Override
    public void run() {
        if (this != null){
        this.gate.addToQueue(this);
        }
    }

    public TicketType getTicketType() {
        return ticketType;
    }

    public FestivalGate getGate() {
        return gate;
    }

    @Override
    public int compareTo(FestivalAttendeeThread o) {
        if(this.ticketType.equals(o.ticketType) && this.gate == o.gate)
        return 0;
        else
            return 1;
    }
}