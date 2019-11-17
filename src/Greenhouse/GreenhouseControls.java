package Greenhouse;
//产生一个控制系统特定的应用程序，全部在一个类里面
//内部类允许你为每种类型的事件封装不同的功能
import my.*;
public class GreenhouseControls extends Controller
{
	
	//控制灯的开关
	private boolean light = false;
	public class LightOn extends Event{
		public LightOn(long delayTime) {super(delayTime);}
		public void action() {
			//把控制硬件的代码放在这里
			//物理的开灯（人为）
			light = true;
		}
		public String toString(){return "Light is on";}
	}
	public class LightOff extends Event{
		public LightOff(long delayTime) {super(delayTime);}
		public void action() {
			//把控制硬件的代码放在这里
			//物理的关灯（人为）
			light = false;
		}
		public String toString() {return "Light is off";}
	}
	
	
	//控制水的开关
	private boolean water = false;
	public class WaterOn extends Event{
		public WaterOn(long delayTime) {super(delayTime);}
		public void action() {
			//把控制硬件的代码放在这里
			//物理的放水（人为）
			water = true;
		}
		public String toString(){return "Water is on";}
	}
	public class WaterOff extends Event{
		public WaterOff(long delayTime) {super(delayTime);}
		public void action() {
			//把控制硬件的代码放在这里
			//物理的关水（人为）
			light = false;
		}
		public String toString() {return "Water is off";}
	}
	
	
	//控温系统
	private String thermostat = "Day";
	public class ThermostatNight extends Event{
		public ThermostatNight(long delayTime) {super(delayTime);}
		public void action() {
			//把控制硬件的代码放在这里
			thermostat = "Night";
		}
		public String toString(){return "Thermostat on night setting";}
	}
	public class ThermostatDay extends Event{
		public ThermostatDay(long delayTime) {super(delayTime);}
		public void action() {
			//把控制硬件的代码放在这里
			thermostat = "Day";
		}
		public String toString() {return "Thermostat on day setting";}
		
		}
	
	
	//下面是一个关于action（）例子，在事件列表中插入一个新事件
	public class Bell extends Event{
		public Bell (long delayTime) {super(delayTime);}
		public void action() {
			addEvent(new Bell(delayTime));
			
		}
		public String toString(){return "Bing!";}
	}
	
	
	//重启系统
	public class Restart extends Event{
		private Event[] eventList;
		public Restart(long delayTime,Event[] eventList) {
			super(delayTime);
			this.eventList=eventList;
			for(Event e : eventList)
				addEvent(e);
		}
		public void action() {
			for(Event e : eventList) {
				e.start();//返回每个事件
				addEvent(e);
			}
			start();//返回重启系统的这个事件；
			addEvent(this);
		}
		public String toString() {
			return "Restart system";
		}
	}
	public static class Terminate extends Event{
		public Terminate(long delayTime) {super(delayTime);}
		public void action() {System.exit(0);}
		public String toString() {return "Terminatings";}
	}
}
