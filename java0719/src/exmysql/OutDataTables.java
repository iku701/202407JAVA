package exmysql;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class OutDataTables extends JFrame {
    JLabel la1 = new JLabel("테이블 이름:");
    JTextField tf1 = new JTextField(10);
    JTextArea ta = new JTextArea(15, 50);
    JButton bt1 = new JButton("검색");

    OutDataTables() {
        JPanel jp1 = new JPanel();
        jp1.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
        jp1.add(la1);
        jp1.add(tf1);
        jp1.add(bt1);

        JPanel jp2 = new JPanel();
        jp2.setLayout(new FlowLayout(FlowLayout.CENTER));
        jp2.add(ta);

        Container con = this.getContentPane();
        con.setLayout(new BorderLayout());
        con.add(jp1, BorderLayout.NORTH);
        con.add(jp2, BorderLayout.CENTER);

        this.setTitle("MyFrame Example");
        this.setBounds(1200, 200, 700, 500);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        bt1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String tableName = tf1.getText();
                if (tableName.equalsIgnoreCase("dept") || tableName.equalsIgnoreCase("emp")) {
                    loadTableData(tableName);
                } else {
                    ta.setText("잘못된 테이블 이름입니다. 'dept' 또는 'emp'를 입력하세요.");
                }
            }
        });
    }

    private void loadTableData(String tableName) {
        String URL = "jdbc:mysql://localhost:3306/spring5fs";
        String user = "spring5";
        String password = "spring5";
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(URL, user, password);
            stmt = con.createStatement();
            String query = "SELECT * FROM " + tableName;
            rs = stmt.executeQuery(query);

            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();

            // Clear previous results
            ta.setText("");

            // Column names
            for (int i = 1; i <= columnCount; i++) {
                ta.append(metaData.getColumnName(i) + "\t");
            }
            ta.append("\n");

            // Data rows
            while (rs.next()) {
                for (int i = 1; i <= columnCount; i++) {
                    ta.append(rs.getString(i) + "\t");
                }
                ta.append("\n");
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            ta.setText("데이터를 불러오는 중 오류가 발생했습니다: " + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new OutDataTables();
    }
}
