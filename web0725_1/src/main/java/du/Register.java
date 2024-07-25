package du;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String name = request.getParameter("name");
        String ssn = request.getParameter("ssn");
        String tel = request.getParameter("tel");
        int balance = Integer.parseInt(request.getParameter("balance"));

        String URL = "jdbc:mysql://localhost:3307/spring5fs";
        Connection conn = null;
        PreparedStatement pstmt = null;
        String sql = "INSERT INTO account (name, ssn, tel, balance) VALUES (?, ?, ?, ?)";
        
        boolean success = false;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(URL, "root", "mysql");
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, name);
            pstmt.setString(2, ssn);
            pstmt.setString(3, tel);
            pstmt.setInt(4, balance);
            int rows = pstmt.executeUpdate();
            
            
            if (rows > 0) {
                success = true;
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        response.setContentType("text/html;charset=utf8");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        if (success) {
            out.println("<h1>회원가입이 완료되었습니다.</h1>");
            out.println("<a href=\"/web0725_1/Index.jsp\">처음으로</a>");
            
        } else {
            out.println("<h1>회원가입에 실패하였습니다. 다시 시도해주세요.</h1>");
            out.println("<a href=\"/web0725_1/Register.jsp\">돌아가기</a>");
        }
        out.println("</html>");
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Redirect to the registration form
        response.sendRedirect("/web0725_1/register.jsp");
    }
}
