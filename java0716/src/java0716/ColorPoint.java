package java0716;

public class ColorPoint extends Point{	//다중상속 불가 Object는 예외

	public ColorPoint() {
		super(100, 200);
		System.out.println("자식기본생성자호출");
		System.out.println(y);
		super.method1();
	} 	//부모클래스에 기본생성자가 있어야한다
	
	public ColorPoint(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}	//부모클래스에 생성자 사용시 extends 사용불가

	@Override
	void method1() {
		
		System.out.println("자식 오버라이딩");
		super.method1();
	}
	
	
	
}
