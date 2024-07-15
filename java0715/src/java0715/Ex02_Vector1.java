package java0715;


import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class Ex02_Vector1 {
	public static void main(String[] args) {
		List<String> list = new Vector<String>(); // 스레드로 개발할때 벡터 사용
		
		list.add("홍길동");
		list.add("자바");
		list.add("Hello");
		
		//이터레이터(자바 디자인 패턴)
		Iterator<String> it = list.iterator();
		while(it.hasNext()) {
			String str = it.next();
			System.out.println(str);
		}
		
		
		
//		for(String str : list) {
//			System.out.println(str);
//		}
	}
}
