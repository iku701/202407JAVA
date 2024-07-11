package java0711;

import java.util.Scanner;

public class PAndM {
	public static void main(String[] args) {
		Scanner stdIo = new Scanner(System.in);
					
		System.out.println("+ 와 - 를 번갈아 출력하는 프로그램");
		System.out.println("반복횟수를 입력해주세요: ");
		int n = stdIo.nextInt();
		
		stdIo.close();
		
		for (int i = 0; i < n/2; i++) {
			System.out.print("+" + "-");
			
		}
		if(n % 2 != 0) {
			System.out.print("+");
		}
	}

}
