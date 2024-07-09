package java0709;
import java.util.Scanner;


public class AppleDivision {

	public static void main(String[] args) {
        int totalApples = 10; 
        Scanner scanner = new Scanner(System.in);
        
        while (true) {

            int applesPerPerson = totalApples / 3;
            int remainingApples = totalApples % 3;
            
     
            System.out.println("총 사과 개수: " + totalApples);
            System.out.println("각 사람이 나눠 가지는 사과의 개수: " + applesPerPerson);
            System.out.println("남는 사과의 개수: " + remainingApples);
            

            System.out.print("계속하려면 'yes'를 입력하세요 (그만하려면 'no'): ");
            String input = scanner.next();
            
            if (input.equalsIgnoreCase("no")) {
                break;
            }
        }
        
        scanner.close();
	}
}
