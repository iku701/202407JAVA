package java0730;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Ex6 {

	public static void main(String[] args) {
//		Class.forName("com.mysql.cj.jdbc.Driver");
		String URL = "jdbc:mysql://localhost:3307/spring5fs";
		List<Score> list = new ArrayList<>();
		try (Connection conn = DriverManager.getConnection(URL, "root", "mysql");
		     Statement stmt = conn.createStatement();
		     ResultSet rs = stmt.executeQuery("SELECT * FROM score")) {
			while (rs.next()) {
				int num = rs.getInt("num");
				String name = rs.getString("name");
				int kor = rs.getInt("kor");
				int eng = rs.getInt("eng");
				int math = rs.getInt("math");
				list.add(new Score(num, name, kor, eng, math));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		list.stream().forEach(System.out::println);

		int korSum = list.stream().mapToInt(Score::getKor).sum();
		double korAvg = list.stream().mapToDouble(Score::getKor).average().orElse(korSum);
		int engSum = list.stream().mapToInt(Score::getEng).sum();
		double engAvg = list.stream().mapToDouble(Score::getEng).average().orElse(engSum);
		int mathSum = list.stream().mapToInt(Score::getMath).sum();
		double mathAvg = list.stream().mapToDouble(Score::getMath).average().orElse(mathSum);
		


		System.out.println("국어 총점: " + korSum);
		System.out.println("국어 평균: " + korAvg);
		
		System.out.println("영어 총점: " + engSum);
		System.out.println("영어 평균: " + engAvg);
		
		System.out.println("수학 총점: " + mathSum);
		System.out.println("수학 평균: " + mathAvg);
		
//		int totalScoreSum = list.stream()
//	            .mapToInt(Score::getTotal)  
//	            .sum();
//		double totalScoreAvg = list.stream()
//				.mapToInt(Score::getTotal)	
//				.average()
//				.orElse(0);
		
		
	}

}