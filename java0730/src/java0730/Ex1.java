package java0730;

import java.text.MessageFormat;
import java.util.ArrayList;
//import java.util.Iterator;
import java.util.List;

public class Ex1 {
	public static void main(String[] args) {
		List<Student> list = new ArrayList<Student>();
		list.add(new Student("Ken", 100));
		list.add(new Student("Shin", 60));
		list.add(new Student("kim", 80));
		
		for(Student st : list) {
			String msg = MessageFormat.format("{0}, {1}", st.getName(), st.getScore());
			System.out.println(msg);
			
		}
		
		System.out.println("---------------");
		
//		Iterator<Student> iterator = list.iterator();
//        while (iterator.hasNext()) {
//            Student st = iterator.next();
//            if (st.getScore() < 70) {
//                iterator.remove();
//            }
//        }
        
//        for (int i = 0; i < list.size(); i++) {
//			if(list.get(i).getScore() < 70) {
//				list.remove(i);
//			}
//		}
		
       list.stream()
       .filter(s->s.getScore() >= 70)
       .forEach(s->System.out.println(s.getName()));
        
       list.stream().forEach(a->{
    	   String msg = MessageFormat.format("{0}, {1}", a.getName(), a.getScore());
    	   System.out.println(msg);
       });
       
//		for(Student st : list) {
//			String msg = MessageFormat.format("{0}, {1}", st.getName(), st.getScore());
//			System.out.println(msg);
//			
//		}
	}
}
