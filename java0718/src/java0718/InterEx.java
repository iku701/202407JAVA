package java0718;

public class InterEx {
	public static void main(String[] args) {
		ImplC implC = new ImplC();
		
		InterA ia = implC;	//변수에 따라서 접근을 제한
		ia.methodA();	
		
		InterB ib = implC;
		ib.methodB();
		
		InterC ic = implC;
		ic.methodA();
		ic.methodB();
		ic.methodC();
	}
}
