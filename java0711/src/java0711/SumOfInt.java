package java0711;

import java.util.Scanner;

public class SumOfInt {
	public static void main(String[] args) {
		
	   Scanner stdIn = new Scanner(System.in);
	   
	   int sum = 0;
	   System.out.println("두개의 정수 사이의 값의 합");
	   
	   
	   
	   System.out.println("첫번째 값을 입력하세요: ");
	   int start = stdIn.nextInt();
	   System.out.println("두번째 값을 입력하세요: ");
	   int last = stdIn.nextInt();
	   
	   stdIn.close();
	   
	   if(start < last) {
		   for (int i = start; i <= last; i++) {
			   sum += i;
		   }
	   }else {
		   for (int i = last; i <= start; i++) {
			   sum += i;
			
		   }
	   }
	   
	   System.out.println(sum);
	   
	}
}
