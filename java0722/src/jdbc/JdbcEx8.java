package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JdbcEx8 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String URL = "jdbc:mysql://localhost:3307/spring5fs";
        Connection conn = null;
        Statement stmt = null;
        
        System.out.print("지역 입력:");
        String str = scanner.nextLine();
        String sql = "SELECT * FROM dept WHERE loc = '" + str + "'";
        System.out.println(sql);
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(URL, "root", "mysql");
            System.out.println("쿼리구문 입력");
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            
//            if(!rs.next()) {
//            	System.out.println("해당 지역이 없습니다.");
//            }
            
            boolean noResults = false;
            
            while (rs.next()) {
                noResults = true; 
                int deptno = rs.getInt("deptno");
                String dname = rs.getString("dname");
                String loc = rs.getString("loc");
                System.out.printf("%d %s %s\n", deptno, dname, loc);
            }
            
            if (!noResults) {
                System.out.println("해당 지역이 없습니다.");
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        scanner.close();
    }
}
