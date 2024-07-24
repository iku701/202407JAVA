package singleton;


public class Singleton {
	//p.301
	private static Singleton singleton = new Singleton();
	private Singleton() { 	//객체를 다른곳에서 쓰지못함
		System.out.println("싱글턴 객체 생성");
	}
	
	public static Singleton getInstance() {
		return singleton;
	}
	
	
}

