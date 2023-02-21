package ch11_8;

import java.util.ArrayList;
import java.util.List;
//���ƿ��
public class Controller
{
    private List<Event> eventList = new ArrayList<>();
    public void addEvent(Event c)
    {
        eventList.add(c);
    }
    public void run()
    {
        while(!eventList.isEmpty())
        {
            for(Event e:new ArrayList<>(eventList))
            {
                if(e.ready())
                {
                    System.out.println(e);
                    e.action();
                    eventList.remove(e);
                }
            }
        }

    }
}
