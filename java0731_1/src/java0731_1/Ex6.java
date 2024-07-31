package java0731_1;

public class Ex6 {
	public static void method(Object object) {
		
		switch(object) {
			case Integer i -> System.out.println(i);
			case null, default -> System.out.println("모른당");
		}
	}
	
	public static void main(String[] args) {
		method(100);
		method(5.777);
		method("가나다");
	}
}
