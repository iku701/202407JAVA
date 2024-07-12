package java0712;

public class Ex1 {
	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
//			System.out.println(Math.random());
			System.out.println((int)(Math.random()*6+1)); //실수형형태로 나오기때문에 강제형변환		
		}
	}
}
