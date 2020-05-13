package blockchain;

import java.util.Date;

public class Clock implements BasicClock {

    Date date = new Date();

    @Override
    public long getTime() {
        return date.getTime();
    }
}
