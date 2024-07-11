package java0711;

import java.util.Scanner;

public class Prob2 {
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		
		System.out.println("1부터 n까지의합 ");
		System.out.println("값 : ");
		int n = stdIn.nextInt();
		stdIn.close();
		
		int sum = 0;
		
		for(int i = 1; i <= n; i++) {
			sum += i;
		}
		
		System.out.println("1부터" + n + "까지의 합은" + sum + "입니다.");
	}
	
}
