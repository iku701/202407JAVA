package java0716;

public class Ex01 {
	public static void main(String[] args) {
		Cat cat = new Cat("페르시안", "검정", 6);	//객체 클래스에 생성자가 생기면 오류 발생
//		cat.age = 9;	//불가능하게하려면 private 사용
		
		System.out.println(cat);
		
	}
}
