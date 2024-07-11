package java0711;

import java.util.Scanner;

public class UntilNsum {
	public static void main(String[] args) {
		Scanner stdIo = new Scanner(System.in);
		
		int sum = 0;
		
		System.out.println("1부터 n까지의 합과 과정");
		System.out.println("슛자를 입력하세요:  ");
		int n = stdIo.nextInt();
		stdIo.close();
		
		for(int i = 0; i <= n; i++) {
			if(i<n) {
				System.out.print(i + "+");
			}else {
				System.out.println(i);
			}
			
			sum += i;
		
		}
		System.out.print("=" + sum);
		
	}
}	
