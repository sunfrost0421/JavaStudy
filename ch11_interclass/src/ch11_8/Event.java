package ch11_8;

import java.time.*;

public abstract class Event
{
    private Instant eventTime;//某个时间点
    protected final Duration delayTime;//一段时间
    public Event(long millisecondDelay)
    {
        delayTime = Duration.ofMillis(millisecondDelay);
        start();
    }
    public void start()
    {
        eventTime = Instant.now().plus(delayTime);
    }
    public boolean ready()
    {
        return Instant.now().isAfter(eventTime);
    }

    public abstract void action();

}
