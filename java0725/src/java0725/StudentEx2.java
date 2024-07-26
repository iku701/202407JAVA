package java0725;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class StudentEx2 {
	public static void main(String[] args) {
		List<Student> list = new ArrayList<Student>();
		list.add(new Student("홍길동", 97));
		list.add(new Student("가길동", 87));
		list.add(new Student("강길동", 69));
		list.add(new Student("천길동", 76));
		list.add(new Student("박길동", 55));
		
		Comparator<Student> c = new Comparator<Student>() {
			
			@Override
			public int compare(Student o1, Student o2) {
				return Integer.compare(o2.getScore(), o1.getScore());
			}
		};
		
		Collections.sort(list, c);
		System.out.println(list);
	}
}