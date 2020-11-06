package school.siit;

import java.util.*;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class FestivalGate {
    public BlockingQueue<FestivalAttendeeThread> queueAtGate = new LinkedBlockingQueue<FestivalAttendeeThread>();

    synchronized public void addToQueue(FestivalAttendeeThread festivalAttendee){
        try {
            queueAtGate.put(festivalAttendee);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    synchronized public void removeFromQueue(FestivalAttendeeThread festivalAttendeeThread){queueAtGate.remove(festivalAttendeeThread);}
}