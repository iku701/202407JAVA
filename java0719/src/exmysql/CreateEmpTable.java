package exmysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateEmpTable {

	public static void main(String[] args) {
		String createString = "CREATE TABLE IF NOT EXISTS `emp` ("
                + "  `EMPNO` int(11) NOT NULL,"
                + "  `ENAME` varchar(10) DEFAULT NULL,"
                + "  `JOB` varchar(9) DEFAULT NULL,\r\n"
                + "  `MGR` int(11) DEFAULT NULL,\r\n"
                + "  `HIREDATE` date DEFAULT NULL,\r\n"
                + "  `SAL` int(11) DEFAULT NULL,\r\n"
                + "  `COMM` int(11) DEFAULT NULL,\r\n"
                + "  `DEPTNO` int(11) DEFAULT NULL\r\n"
                + ") ENGINE=InnoDB DEFAULT CHARSET=utf8;\r\n";
		
		
		
		String URL = "jdbc:mysql://localhost:3306/spring5fs";
		Connection con = null;
		Statement stmt = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(URL, "spring5", "spring5");
			System.out.println("Mysql 접속 성공!");
			stmt = con.createStatement();
			int num = stmt.executeUpdate(createString);
			System.out.println("테이블 생성! "+ num);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
