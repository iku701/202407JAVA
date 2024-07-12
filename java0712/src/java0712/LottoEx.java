package java0712;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class LottoEx {
	public static void main(String[] args) {
		int[] lotto = new int[6]; // 인덱스 0~5개(6개)	
		Random rand = new Random();
		
		Set<Integer> lottoSet = new HashSet<>(); //중복을 허용하지 않는 set 사용
		
		while(lottoSet.size()<6) {
			int number = rand.nextInt(45) + 1;
			lottoSet.add(number);
		}
		
//		lottoSet.add(2);
//		lottoSet.add(2);
//		System.out.println(lottoSet.size());
		System.out.println(lottoSet);
		
		
		
		
	}
}
