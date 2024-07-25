package java0725;

public class Ex4 { 
	//예외 떠넘기기 throws
	public static void method() throws ClassNotFoundException {
		Class.forName("asd.asd.asd");
	}
	
	public static void main(String[] args) {
		try {
			method();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
