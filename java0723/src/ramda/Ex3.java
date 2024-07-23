package ramda;

public class Ex3 {
	public static void main(String[] args) {
		Myinterf2 myinterf2 = (a)->{ 	//매개변수를 넣지않으면 오류
			System.out.println(a+300);
		};
		myinterf2.method(100);
		
	}
}
