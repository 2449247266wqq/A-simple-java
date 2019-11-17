package my;
//这是控制事件的公共方法
public abstract class Event
{
	private long eventTime;
	protected final long delayTime;
	public Event(long delayTime) {
		this.delayTime=delayTime;
		start();
	}
	public void start() {
		eventTime = System.nanoTime()+delayTime;
	}
	public boolean ready() {
		return System.nanoTime()>=eventTime;
	}
	public abstract void action();
}
