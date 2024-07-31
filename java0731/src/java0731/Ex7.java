package java0731;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;

public class Ex7 {
	public static void main(String[] args) {
		List<Integer> list= new ArrayList<Integer>();
		
		double avg = list.stream()
				.mapToInt(Integer::intValue)
				.average()
				.getAsDouble();
		System.out.println(avg);
		
		//1
		OptionalDouble avg2 = list.stream()
				.mapToInt(Integer::intValue)
				.average()
		;
		if(avg2.isPresent()) {
			System.out.println(avg2.getAsDouble());
		}else {
			System.out.println("존재하지않음");
		}
		
		//2
		double avg1 = list.stream()
				.mapToInt(Integer::intValue)
				.average()
				.orElse(0);
		System.out.println(avg1);
		
		//3
		list.stream()
			.mapToInt(Integer::intValue)
			.average()
			.ifPresent(a -> System.out.println(a));
	}
}
