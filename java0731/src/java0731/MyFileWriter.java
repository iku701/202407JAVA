package java0731;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class MyFileWriter {
	public static void main(String[] args) throws IOException {
		File dir = new File("C:/Temp/txt");
		if(dir.exists() == false) {
			dir.mkdir();
		}
		
		Writer writer = new FileWriter("C:/Temp/txt/file2.txt");
		String str = "ABC ㅎㅇ";
		writer.write(str);
		writer.flush(); 	// 출력버퍼를 지움
		writer.close();
		
	}
}
