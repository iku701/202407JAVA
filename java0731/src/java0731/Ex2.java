package java0731;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.Properties;

public class Ex2 {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		Properties properties = new Properties(); 	//해시맵 하위클래스
		String path = Ex2.class.getResource("database.properties").getPath();
		path = URLDecoder.decode(path, "utf-8");
		System.out.println(path);
		properties.load(new FileReader(path));
		String username = properties.getProperty("username");
		System.out.println("username : " + username);
	}
}
