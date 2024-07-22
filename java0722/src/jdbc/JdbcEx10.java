package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JdbcEx10 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String URL = "jdbc:mysql://localhost:3307/spring5fs";
        Connection conn = null;
        Statement stmt = null;
        
        String sql1 = String.format("select max(deptno) from dept");
        
        System.out.println("부서명: ");		
        String strName = scanner.nextLine();
        System.out.println("부서지역: ");
        String strLoc = scanner.nextLine();
        
        String sql2 = null;
        
        System.out.println(sql2);
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(URL, "root", "mysql");
            System.out.println("쿼리구문 입력중...");
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql1);
            rs.next();
            int maxNo = rs.getInt(1);
            
            System.out.println(maxNo);
            
            sql2 = String.format("insert into dept(deptno, dname, loc) values (%d, '%s', '%s')", maxNo+1, strName, strLoc);
            
            int res = stmt.executeUpdate(sql2);
            System.out.println(res + "건을 입력!");
  
            
           
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } 
        scanner.close();
    }
}
