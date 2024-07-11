package java0711;

import java.util.Scanner;

public class InputPlusInt {
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		
		System.out.println("2자리의 양수만 출력하는 프로그램");
		System.out.println("숫자를 입력해주세요: ");
		int n = stdIn.nextInt();
		stdIn.close();
		
		if(10 <= n && n <= 100  ) {
			System.out.println("해당 숫자는 두자리 양수입니다.");
		}else {
			System.out.println("두자리의 양수가 아닙니다.");
		}
	}
}
