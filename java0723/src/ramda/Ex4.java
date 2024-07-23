package ramda;

public class Ex4 {
	public static void main(String[] args) {
		Myinterf3 myinterf3 = (a,b) -> {
			System.out.println(a+b);
		};
		myinterf3.method(300, 400);
	}
}
