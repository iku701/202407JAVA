package java0716;

public class Calculator {
	int x, y;
	
	int plus() {
		int result = x + y;
		return result;
	}
	
	double avg() {
//		double sum = plus(x, y);
//		double result = sum/2;
		return this.plus() / 2.0;
	
	}
	
	void execute() {
//		double result = avg();
		println("실행결과 : " + avg());
	}
	
	void println(String msg) {
		System.out.println(msg);
	}
}
