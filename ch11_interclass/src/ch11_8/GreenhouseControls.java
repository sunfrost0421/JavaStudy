package ch11_8;

import java.util.Arrays;
import java.time.*;

public class GreenhouseControls extends Controller
{
    private boolean light = false;
    public class LightOn extends Event
    {
        public LightOn(long delayTime)
        {
            super(delayTime);
        }

        @Override
        public void action() {
            light = true;
        }

        @Override
        public String toString() {
            return "Light is On.    "+System.currentTimeMillis();
        }
    }

    public class LightOff extends Event
    {
        public LightOff(long delayTime)
        {
            super(delayTime);
        }

        @Override
        public void action() {
            light = false;
        }

        @Override
        public String toString() {
            return "Light is Off.    "+System.currentTimeMillis();
        }
    }

    public class Bell extends Event
    {
        public Bell(long delayTime)
        {
            super(delayTime);
        }
        @Override
        public void action() {
            addEvent(new Bell(delayTime.toMillis()));
        }

        @Override
        public String toString() {
            return "Bing!    "+System.currentTimeMillis();
        }
    }

    public class Restart extends Event
    {
        private Event[] eventList;
        public Restart(long delayTime, Event[] eventList)
        {
            super(delayTime);
            this.eventList = eventList;
            for(Event e:eventList)
                addEvent(e);
        }

        @Override
        public void action() {
            for(Event e:eventList)
            {
                e.start();
                addEvent(e);
            }
            start();
            addEvent(this);
        }

        @Override
        public String toString() {
            return "Restarting system    "+System.currentTimeMillis();
        }
    }

    public static class Terminate extends Event{
        public Terminate(long delayTime)
        {
            super(delayTime);
        }

        @Override
        public void action() {
            System.exit(0);
        }

        @Override
        public String toString() {
            return "Terminating.    "+System.currentTimeMillis();
        }
    }
}
