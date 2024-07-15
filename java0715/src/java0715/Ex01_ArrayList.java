package java0715;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Ex01_ArrayList {
	public static void main(String[] args) {
		ArrayList<String> list;		//String list[]; << 배열의 단점이 존재함 유틸리티가 없음
		list = new ArrayList<String>(); 
		ArrayList<String> list2 = new ArrayList<String>();
		ArrayList<String> list3 = new ArrayList<>();
		List<String> list4 = new ArrayList<String>();
		
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
