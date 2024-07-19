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

public class SelectOutDataTables extends JFrame {
    JLabel la1 = new JLabel("SQL 쿼리:");
    JTextField tf1 = new JTextField(30);
    JTextArea ta = new JTextArea(15, 50);
    JButton bt1 = new JButton("실행");

    SelectOutDataTables() {
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

        this.setTitle("SQL Query Executor");
        this.setBounds(1200, 200, 700, 500);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        bt1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String query = tf1.getText();
                if (query.toLowerCase().startsWith("select")) {
                    executeQuery(query);
                } else {
                    ta.setText("유효한 SELECT 쿼리를 입력하세요.");
                }
            }
        });
    }

    private void executeQuery(String query) {
        String URL = "jdbc:mysql://localhost:3306/spring5fs";
        String user = "spring5";
        String password = "spring5";

        try (Connection con = DriverManager.getConnection(URL, user, password);
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            Class.forName("com.mysql.cj.jdbc.Driver");

            displayResultSet(rs);

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            ta.setText("데이터를 불러오는 중 오류가 발생했습니다: " + e.getMessage());
        }
    }

    private void displayResultSet(ResultSet rs) throws SQLException {
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
    }

    public static void main(String[] args) {
        new SelectOutDataTables();
    }
}
