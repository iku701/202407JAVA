package sec01.exam04;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ReadExample {
	public static void main(String[] args) throws IOException {
		InputStream is = new FileInputStream("C:/Temp/test1.db");
		int cnt= 0;
		byte[] buf = new byte[5];
		
		int data = is.read(buf, 2, 3);
		for(int i = 0; i < buf.length; i++) {
			System.out.println(buf[i]);
		}
		System.out.println(cnt);
		is.close();
	}
}
