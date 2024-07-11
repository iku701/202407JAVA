package java0711;

import java.util.Scanner;

public class NumberChangeLine {
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		
	
		
		System.out.println(" *을 n번 w개의 줄마다 출력 프로그램 ");
		System.out.println("n의 값을 정해주세요 : ");
		int n = stdIn.nextInt();
		System.out.println("w의 값을 정해주세요 : ");
		int w = stdIn.nextInt();
		
		stdIn.close();
		
		for (int i = 1; i <= n; i++) {
			System.out.print("*");
			if(i % w == 0) {
				System.out.print("\n");
			}
		}
	}
}
