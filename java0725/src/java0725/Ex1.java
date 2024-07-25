package java0725;

class Parent{
	int x;
	void method(){
		System.out.println(x);
	}
}

public class Ex1 {
	public static void main(String[] args) {
		Parent parent = new Parent() {
			
			void method2() {
				System.out.println("오직 나만 사용");
			}

			@Override
			void method() {
				x = 100;
				System.out.println("익명 자식객체 생성");
				super.method();
				method2();
			}
			
		};
		parent.method();
//		parent.method2(); 	//익명 내부에서 생성된 메소드는 사용불가능 
	}
}
