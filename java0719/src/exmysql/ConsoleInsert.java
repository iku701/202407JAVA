package exmysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class ConsoleInsert {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("부서 번호를 입력하세요 (int): ");
        int deptNo = scanner.nextInt();
        scanner.nextLine(); 

        System.out.println("부서 이름을 입력하세요 (String): ");
        String dname = scanner.nextLine();

        System.out.println("부서 위치를 입력하세요 (String): ");
        String loc = scanner.nextLine();

        String insertString = String.format("INSERT INTO dept (DEPTNO, DNAME, LOC) VALUES (%d, '%s', '%s')",
                deptNo, dname, loc);

        String URL = "jdbc:mysql://localhost:3306/spring5fs";
        Connection con = null;
        Statement stmt = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(URL, "spring5", "spring5");
            System.out.println("Mysql 접속 성공!");
            stmt = con.createStatement();
            int num = stmt.executeUpdate(insertString);
            System.out.println("테이블에 자료 삽입: " + num + " 행이 삽입되었습니다.");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            
            try {
                if (stmt != null) stmt.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        scanner.close();
    }
}
