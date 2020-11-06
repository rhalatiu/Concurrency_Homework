package school.siit;

import java.util.Random;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        FestivalGate gate = new FestivalGate();

        Random randomizer = new Random();
        int n = randomizer.nextInt(999 - 100) + 100;

        FestivalStatisticsThread statsThread = new FestivalStatisticsThread(gate);
        Thread newThread = new Thread(statsThread);
        newThread.start();

        for (int i = 0; i < n; i++){
            TicketType ticketType =  TicketType.generateTicketType();

            FestivalAttendeeThread festivalAttendee = new FestivalAttendeeThread(ticketType, gate);
            Thread anotherNewThread = new Thread(festivalAttendee);
            anotherNewThread.start();
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Thread.sleep(6000);
        newThread.stop();
    }
}