package java0710;

public class Ex2 {
	public static void main(String[] args) {
		
		
		
		String str3 = new String("가나다");
		String str4 = new String("가나다");
		boolean result3 = str3 == str4;
		System.out.println(result3);		//주소개념이기에 false
		
		String str1 = "가나다";
		String str2 = "가나다";
		boolean result2 = str1 == str2;
		System.out.println(result2);
		
		int x = 0;
		++x;
		System.out.println(x);
		
	}

}
