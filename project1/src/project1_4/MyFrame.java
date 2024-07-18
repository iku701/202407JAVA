package project1_4;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
	JLabel la1 = new JLabel("아이디"); 
	JLabel la2 = new JLabel("패스워드"); 
	JLabel la3 = new JLabel("전화번호");
	
	JTextField tf1 = new JTextField(5); 
	JTextField tf2 = new JTextField(5);
	JTextField tf3 = new JTextField(10);
	
	JTextArea ta = new JTextArea(20, 50);
	
	JButton bt1 = new JButton("로그인"); 
	JButton bt2 = new JButton("회원가입"); 
	JButton bt3 = new JButton("예금");
	JButton bt4 = new JButton("출금"); 
	JButton bt5 = new JButton("잔고");
	
	List<Member> list;
	Member member;
	
	MyFrame() {
		//회원정보 읽기
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
        jp1.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
        jp1.add(la1); jp1.add(tf1);
        jp1.add(la2); jp1.add(tf2);
        jp1.add(la3); jp1.add(tf3);

        JPanel jp2 = new JPanel();
        jp2.setLayout(new FlowLayout());
        jp2.add(ta);

        JPanel jp3 = new JPanel();
        jp3.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
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
		this.addWindowListener(new JFrameWindowClosingEventHandler());
		
		//로그인버튼 이벤트
		bt1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String name = tf1.getText();
				String strPassword = tf2.getText();
				boolean loginSuccess = false;
				
				for (Member member2 : list) {
					if (member2.getName().equals(name) && member2.getSsn().equals(strPassword)) {
						member = member2;
						loginSuccess = true;
						break;
					}
				}
				
				if(loginSuccess == true) {
					ta.setText("로그인되었습니다. \n어서오세요 " + member.getName() + "님");
				}else {
					ta.setText("로그인실패했습니다. \n아이디와 패스워드를 재입력해주세요." );
				}
				
				tf1.setText("");
		        tf2.setText("");
				
			}
		});
		
		//회원가입버튼 이벤트
		bt1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String name2 = tf1.getText();
                String ssn = tf2.getText();
                String tel = tf3.getText();
                list.add(new Member(name2, ssn, tel));

                ta.setText(name2 + "님의 정보가 저장되었습니다.");

                tf1.setText("");
                tf2.setText("");
                tf3.setText("");
			}
			
		});
		
	}
	
	class JFrameWindowClosingEventHandler extends WindowAdapter {
		
		@Override
		public void windowClosing(WindowEvent e) {
			// 파일 저장 위치
			Member[] list2 = list.toArray(new Member[list.size()]); // ArrayList를 배열로
			try (FileOutputStream fos = new FileOutputStream("c:\\temp\\members.dat");
		             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
				 oos.writeObject(list2);
		         System.out.println("객체를 파일에 저장했습니다.");
				
				
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			
			JFrame frame = (JFrame)e.getWindow();
			frame.dispose();
			System.out.println("windowClosing()");
		}
	}
	
	public static void main(String[] ar) {
		new MyFrame();
	}

}