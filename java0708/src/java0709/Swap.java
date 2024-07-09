package java0709;

public class Swap {
	
	public static void swap(int a, int b) {
		int tmp = a;
		a = b;
		b = tmp;
		System.out.printf("a = %d, b = %d\n", a, b);
	}
	
	public static void main(String[] args) {
		int x = 10;
		int y = 20;
		System.out.printf("x = %d, y = %d\n", x, y);
		//swap
		int tmp = x;
		x = y;
		y = tmp;
		System.out.printf("x = %d, y = %d\n", x, y);
	}

}
