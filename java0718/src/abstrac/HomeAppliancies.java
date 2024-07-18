package abstrac;

public abstract class HomeAppliancies {
	private int seriaNo;
	private String manufacturer;
	private int year;
	
	public void turnOn() {
		System.out.println("시스템 동작");
	}
	
	public void turnOff() {
		System.out.println("시스템 중지");
	}
}
