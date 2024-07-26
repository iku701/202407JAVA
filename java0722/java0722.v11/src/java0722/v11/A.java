package java0722.v11;

public class A {
	B field1 = new B();
	C field2 = new C();
	
//	static B field3 = new B();
	static C field4 = new C();
	
	void method() {
		B var1 = new B();
		C var2 = new C();
	}
	
	static void method2() {
//		B var1 = new B();
		C var2 = new C();
	}
	
	
	class B{}
	static class C{}
	
}
// static으로 선언된다면 static에서만 사용가능
