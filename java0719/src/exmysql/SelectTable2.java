package exmysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectTable2 {

    public static void main(String[] args) {
    	String sql = "select * from dept";
		
		String URL = "jdbc:mysql://localhost:3306/spring5fs";
		Connection con = null;
		Statement stmt = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(URL, "spring5", "spring5");
			System.out.println("Mysql 접속 성공!");
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			//메커니즘중요
			while(rs.next()) { 	//자료가 있는지 확인여부 true, false
				System.out.print(rs.getString("deptno") + " \t ");
				System.out.print(rs.getString("dname") + " \t ");
				System.out.println(rs.getString("loc"));
				
			}
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
