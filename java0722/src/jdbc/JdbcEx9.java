package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JdbcEx9 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String URL = "jdbc:mysql://localhost:3307/spring5fs";
        Connection conn = null;
        Statement stmt = null;
        
        System.out.println("부서번호: ");
        String strNo = scanner.nextLine();
        System.out.println("부서명: ");
        String strName = scanner.nextLine();
        System.out.println("부서지역: ");
        String strLoc = scanner.nextLine();
        
        
        String sql = String.format("insert into dept(deptno, dname, loc) values ('%s', '%s', '%s')", strNo, strName, strLoc);
        
        System.out.println(sql);
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(URL, "root", "mysql");
            System.out.println("쿼리구문 입력");
            stmt = conn.createStatement();
            int res = stmt.executeUpdate(sql);
            System.out.println(res + "건을 입력!");
  
            
           
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } 
        scanner.close();
    }
}
