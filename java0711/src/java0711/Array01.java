package java0711;



public class Array01 {
	public static void main(String[] args) {
		
		int scores[] = {83, 90, 87};    
	//	int scores[] = new int[] {83, 90, 87}; 와 같다
		
//		for (int i = 0; i < scores.length; i++) {
//			System.out.println(scores[i]);
//		}
//	
		double sum = 0;
		double avg = 0;
		
		for (int i = 0; i < scores.length; i++) {
			sum += scores[i];
			
		}
		
		System.out.println("총계: " + sum);
		avg = sum / scores.length;
		System.out.println("평균: " + avg);
//		
//		
//
// 		int myArr[] = new int[5];
// 		
// 		
//		for (int i = 0; i < 5; i++) {
//			System.out.println(myArr[i]);
//		}
//		
//		double myArr2[] = new double[5];
//		
//		for (int i = 0; i < 5; i++) {
//			System.out.println(myArr2[i]);
//		}
//		
//		boolean myArr3[] = new boolean[5];
//		
//		for (int i = 0; i < 5; i++) {
//			System.out.println(myArr3[i]);
//		}
	}
}
