package project2;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class MyFrame extends JFrame {
    JLabel la1 = new JLabel("아이디:");
    JLabel la2 = new JLabel("패스워드:");
    JLabel la3 = new JLabel("전화번호:");

    JTextField tf1 = new JTextField(10);
    JTextField tf2 = new JTextField(10);
    JTextField tf3 = new JTextField(10);

    JTextArea ta = new JTextArea(20, 30);

    JButton bt1 = new JButton("로그인");
    JButton bt2 = new JButton("회원가입");
    JButton bt3 = new JButton("예금");
    JButton bt4 = new JButton("출금");
    JButton bt5 = new JButton("잔고");
    
    List<Member> list;
	Member member;

    MyFrame() {
    	//저장된 회원정보 불러오기
    	try (FileInputStream fis = new FileInputStream("c:\\temp\\members.dat");
	             ObjectInputStream ois = new ObjectInputStream(fis)) {
			Member[] list2 = (Member[]) ois.readObject();
			list = new ArrayList<>(Arrays.asList(list2));   // 배열을 ArrayList로
			System.out.println("파일에서 객체를 가져왔습니다.");
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		for (Member member : list) {
			System.out.println(member);
		}
		System.out.println("총회원수:"+list.size());
		
    	
        JPanel jp1 = new JPanel();
        jp1.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 20));
        jp1.add(la1); jp1.add(tf1);
        jp1.add(la2); jp1.add(tf2);
        jp1.add(la3); jp1.add(tf3);

        JPanel jp2 = new JPanel();
        jp2.setLayout(new FlowLayout(FlowLayout.LEFT));
        jp2.add(ta);

        JPanel jp3 = new JPanel();
        jp3.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
        jp3.add(bt1);
        jp3.add(bt2);
        jp3.add(bt3);
        jp3.add(bt4);
        jp3.add(bt5);

        // 컨테이너 설정
        Container con = this.getContentPane();
        con.setLayout(new BorderLayout());
        con.add(jp1, BorderLayout.NORTH);
        con.add(jp2, BorderLayout.CENTER);
        con.add(jp3, BorderLayout.SOUTH);

        this.setTitle("MyFrame Example");
        this.setBounds(1200, 200, 700, 500);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new MyFrame();
    }
}
