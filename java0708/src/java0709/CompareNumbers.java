package java0709;
import java.util.Scanner;

public class CompareNumbers {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
    
        System.out.print("첫 번째 숫자를 입력하세요: ");
        int number1 = scanner.nextInt();
        
       
        System.out.print("두 번째 숫자를 입력하세요: ");
        int number2 = scanner.nextInt();
        
        if(number1 == number2) {
        	System.out.print("두수는 같습니다.");
        	
        	scanner.close();
        }
        
        else {
        	int maxNumber = (number1 > number2) ? number1 : number2;
            
            
            System.out.println("입력한 숫자 중 큰 수는 " + maxNumber + "입니다.");
            
            scanner.close();
        }
    }
}
