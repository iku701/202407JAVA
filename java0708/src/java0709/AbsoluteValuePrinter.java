package java0709;
import java.util.Scanner;

public class AbsoluteValuePrinter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("정수를 입력하세요: ");
        int number = scanner.nextInt();
        
        if (number < 0) {
            number = -number;
        }

        System.out.println("출력 값: " + number);
            scanner.close(); 
    }
}