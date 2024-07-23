package ramda;

public class Ex5 {
	public static void main(String[] args) {
		Myinterf4 myinterf4 = (x, y) -> {return x+y;};
	
		
		int t = myinterf4.method(100, 700);
		System.out.println(t);
	}
}
