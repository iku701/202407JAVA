package java0711;

import java.util.Scanner;

public class UntilNsumVersion2 {
	public static void main(String[] args) {
		Scanner stdIo = new Scanner(System.in);
		
		int sum = 0;
		
		System.out.println("1부터 n까지의 합과 과정");
		System.out.println("슛자를 입력하세요:  ");
		int n = stdIo.nextInt();
		stdIo.close();
		
		for(int i = 1; i < n; i++) {
			System.out.print(i + "+");
			
			sum += i;
		
		}
		System.out.print(n + "=");
		sum += n;
		System.out.println(sum);
		
	}
}	

