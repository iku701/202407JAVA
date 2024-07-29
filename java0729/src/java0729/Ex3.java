package java0729;

public class Ex3 {
	public static void main(String[] args) {
		
		int x = 100;
		Integer y; 	//클래스타입(좀더 다양하게 쓰임)
		Integer z = 400;
		y = 100;
		
		x = Integer.valueOf("400");
		y = Integer.valueOf("400");
		if(y.equals(z)) {
			System.out.println("같다");
		}else {
			System.out.println("다르다");
		}
		
		String str1 = 123 + "";
		String str2 = String.valueOf(123);
		
		System.out.println(str1);
		System.out.println(str2);
		
		String str = new String("이것은 자바 대치 예제입니다.");
		String newstr = str.replace("예제", "JAVA"); 		//값은 같지만 저장소는 다름
		System.out.println(str);
		System.out.println(newstr);
	}
}
