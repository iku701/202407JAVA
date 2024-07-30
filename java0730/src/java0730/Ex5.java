package java0730;

import java.util.stream.IntStream;

public class Ex5 {
	public static void main(String[] args) {
		int count = 10;
		int sum = IntStream.rangeClosed(1, count).sum();
		System.out.println(sum);
		
		
		
//		IntStream ii = IntStream.range(1, 5);
//		IntStream iii = IntStream.rangeClosed(1, 5);
////		ii.forEach(System.out::println);
//		ii.forEach(a->{
//			System.out.println(a);
//		});
//		
//		System.out.println("----------------");
//		
//		iii.forEach(a->{
//			System.out.println(a);
//		});
	}
}
