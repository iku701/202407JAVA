package java0710;

import java.util.Scanner;

public class ForEx4 {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		for (;;) {
			System.out.print("명령>>");
			
			String input = scan.nextLine();
		
			if(input.equalsIgnoreCase("q")) {
				break;
			}
			
		}
	}
}
