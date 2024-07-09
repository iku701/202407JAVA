package java0709;

import java.util.Scanner;


public class MaxOfThree {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

      
        System.out.print("첫 번째 정수를 입력하세요: ");
        int num1 = scanner.nextInt();

        System.out.print("두 번째 정수를 입력하세요: ");
        int num2 = scanner.nextInt();

        System.out.print("세 번째 정수를 입력하세요: ");
        int num3 = scanner.nextInt();

       
        int max = getMax(num1, num2, num3);

        
        System.out.println("세 정수 중 최대값은: " + max);
        
        scanner.close();
    }

    
    public static int getMax(int a, int b, int c) {
        int max = a;  
        if (b > max) {
            max = b;
        }
        if (c > max) {
            max = c;
        }
        return max;
    }
}