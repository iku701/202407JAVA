package java0710;

public class Ex1 {
	
	public static void main(String[] args) {
	//	String str1 = 10 + "";
		
		double s1 = Double.parseDouble("100.345") + 3;
		System.out.println(s1);
		
		String s2 = 3 + "100";
		System.out.println(s2);
		
		int x1 = 1;
		int x2 = 3;
		int x3 = x1 / x2;
		System.out.println(x3);
		
		double res3 =  (double) x1 /x2;
		System.out.println(res3);
		
		float result = (float) (1.5 + 3.4);
	//	double res2 = 1.5 + 3.4;
		System.out.println(result);
		
	//	byte a1 = 10;
	//	byte b2 = 20;
	//	byte c3 = (byte) (a1 + b2);
		
	//	int s1 = (a1 + b2);
		System.out.println(s1);
		
		byte b1 = 65;
		char c1 = (char) b1;
		System.out.println(c1);
		
		double d1 = 3.54;
		int z = (int) d1;
		System.out.println(z);
		
	}

}
