package java0716;

public class Point {
	int x,y;
	
	public Point() {
		System.out.println("부모기본생성자호출");
	}
	
	public Point(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	void method1() {
		System.out.println(x + "," + y);
	}
}
