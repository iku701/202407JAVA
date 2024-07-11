package java0710;
import java.util.Scanner;

public class SwithCaseGradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("점수를 입력하세요 (0-100): ");
        int score = scanner.nextInt();

        char grade = getGrade(score);

        System.out.println("점수에 따른 학점은: " + grade);
        
        scanner.close();
    }

    public static char getGrade(int score) {
        if (score < 0 || score > 100) {
            throw new IllegalArgumentException("점수는 0과 100 사이여야 합니다.");
        }

        switch (score / 10) {
            case 10: 
            case 9:
                return 'A';
            case 8:
                return 'B';
            case 7:
                return 'C';
            case 6:
                return 'D';
            default:
                return 'F';
        }
    }
}