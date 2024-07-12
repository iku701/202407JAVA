package java0712;

import java.util.Scanner;

public class ArrScoreAvg {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("학생수 입력하세요: ");
		int num = Integer.parseInt(sc.nextLine());
		double arr[][] = new double[num][3];
		
		double sum = 0.0;
		double avg = 0.0;
		
		
		for (int i = 0; i < arr.length; i++) {
            System.out.println((i + 1) + "번째 학생");
            System.out.println("국어 점수: ");
            arr[i][0] = Double.parseDouble(sc.nextLine());
            System.out.println("수학 점수: ");
            arr[i][1] = Double.parseDouble(sc.nextLine());
            sc.close();
           
        }
		//학생별 점수 나열
		System.out.println("\n학생별 점수:");
        for (int i = 0; i < arr.length; i++) {
            System.out.println((i + 1) + "번째 학생의 점수 - 국어: " + arr[i][0]+ "점" + ", 수학: " + arr[i][1]+"점");
        }
		
		
		
		for (int i = 0; i < arr.length; i++) {
            
            for (int j = 0; j < arr[i].length; j++) {
                sum += arr[i][j];
            }
            avg = sum / arr[i].length;
            System.out.println((i + 1) + "번째 학생의 평균 점수: " + avg + "점");
        }

	}
}
