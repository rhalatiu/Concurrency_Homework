package school.siit;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class FestivalStatisticsThread implements Runnable{
    private FestivalGate gate;

    public FestivalStatisticsThread(FestivalGate gate) {
        this.gate = gate;
    }

    @Override
    public void run() {
        while (true) {
            if (this.gate.queueAtGate != null && this.gate.queueAtGate.size() != 0) {

                System.out.println(this.gate.queueAtGate.size() + " people entered");

                BlockingQueue<FestivalAttendeeThread> queue = new LinkedBlockingQueue<FestivalAttendeeThread>();
                queue = this.gate.queueAtGate;

                int countFullTicket = 0;
                int countFullVIPTicket = 0;
                int countFreePassTicket = 0;
                int countOneDayTicket = 0;
                int countOneDayVipTicket = 0;

               for (FestivalAttendeeThread f : queue) {
                //FestivalAttendeeThread f = null;
                try {
                    f = this.gate.queueAtGate.take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                switch (f.getTicketType()) {
                        case FULL:
                            countFullTicket++;
                        case FULL_VIP:
                            countFullVIPTicket++;
                        case FREE_PASS:
                            countFreePassTicket++;
                        case ONE_DAY:
                            countOneDayTicket++;
                        case ONE_DAY_VIP:
                            countOneDayVipTicket++;
                        default:
                            ;
                    }
                    this.gate.removeFromQueue(f);
               }

                System.out.println(countFullTicket + " people have full tickets");
                System.out.println(countFullVIPTicket + " have free passes");
                System.out.println(countFreePassTicket + " have full VIP passes");
                System.out.println(countOneDayTicket + " have one-day passes");
                System.out.println(countOneDayVipTicket + " have one-day VIP passes");

                System.out.println("------------------------------------------");
            }

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}