package school.siit;

import java.util.Random;

public enum TicketType {
    FULL, FULL_VIP, FREE_PASS, ONE_DAY, ONE_DAY_VIP;

    public static TicketType generateTicketType(){
        Random randomTicketType = new Random();
        switch (randomTicketType.nextInt(5)){
            case 0:
                return FULL;
            case 1:
                return FULL_VIP;
            case 2:
                return FREE_PASS;
            case 3:
                return ONE_DAY;
            case 4:
                return ONE_DAY_VIP;
            default:
                return null;
        }
    }
}


