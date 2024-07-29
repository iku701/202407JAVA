package java0729;

import java.util.Date;


import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Ex4 {
	public static void main(String[] args) {
		Date now = new Date();
		System.out.println(now);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd"); 		//현업에서 자주사용
		String strNow = sdf.format(now);
		System.out.println(strNow);
		
		LocalDateTime now1 = LocalDateTime.now();
		String strNow1 = DateTimeFormatter.ofPattern("yyy/MM/dd").format(now1);
		System.out.println(now1);
		
	}
}
