package java0710;
import java.util.Scanner;

public class Prob_6 {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("구구단의 단을 입력하세요 (2에서 9 사이의 숫자): ");
        int dan = scanner.nextInt();
        
      
        if (dan < 2 || dan > 9) {
            System.out.println("잘못된 입력입니다. 구구단은 2에서 9 사이의 숫자를 입력해야 합니다.");
            scanner.close();
            return;
        }
        
      
        for (int i = 1; i <= 9; i++) {
            System.out.println(dan + " x " + i + " = " + (dan * i));
        }
        
        scanner.close();
    }
}
