package my;
//控制系统可再度使用的框架
import java.util.*;

public class Controller
{
	private List<Event> eventList = new ArrayList<Event>();
	public void addEvent(Event c) {eventList.add(c);}
	public void run() {
		while(eventList.size()>0)
			for(Event e:new ArrayList<Event>(eventList))
				if(e.ready()) {
					System.out.println(e);
					e.action();
					eventList.remove(e);
				}
	}

}
