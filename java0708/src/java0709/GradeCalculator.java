package java0709;
import java.util.Scanner;

public class GradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("점수를 입력하세요 (0-100): ");
        int score = scanner.nextInt();

        char grade = getGrade(score);

        System.out.println("점수에 따른 학점은: " + grade);
        
        scanner.close();
    }


    public static char getGrade(int score) {
        if (score >= 90 && score <= 100) {
            return 'A';
        } else if (score >= 80 && score < 90) {
            return 'B';
        } else if (score >= 70 && score < 80) {
            return 'C';
        } else if (score >= 60 && score < 70) {
            return 'D';
        } else if (score >= 0 && score < 60) {
            return 'F';
        } else {
            throw new IllegalArgumentException("점수는 0과 100 사이여야 합니다.");
        }
    }
}