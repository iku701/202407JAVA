package java0712;

import java.util.Random;

public class RecursionEx {
	public static void main(String[] args) {
		
		Random rd = new Random();
		
		for (int i = 0; i < 10; i++) {
//			System.out.println((int)(Math.random()*6+1));
//			System.out.println(rd.nextInt(10));
			System.out.print(rd.nextInt(45)+1 + " ");
			
		}
	}
}
