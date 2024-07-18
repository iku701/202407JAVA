package java0718;

import javax.swing.*;  
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.classfile.constantpool.IntegerEntry;
 

public class Cal3 extends JFrame {

	JTextField num1, num2;
	JButton plus, minus, multiply, divide;
	JLabel label02;
	
	public Cal3() {
		
		setTitle("계산기 화면");
		setSize(300, 250);	

		
		JPanel titlePanel = new JPanel();
		titlePanel.setBounds(0, 0, 300,40);
		add(titlePanel);
		JLabel title = new JLabel("계산기", JLabel.CENTER);
		title.setFont(new Font("함초롱돋움", Font.BOLD, 20));
		titlePanel.add(title);	

		
			
		JPanel numPanel = new JPanel();		
		numPanel.setBounds(0, 40, 300, 40);
		add(numPanel);		
		num1 = new JTextField(5);	
		numPanel.add(num1);
		num2 = new JTextField(5);
		numPanel.add(num2);
	
		
		
		JPanel btPanel01 = new JPanel();	
		btPanel01.setBounds(0, 80, 300, 40);
		add(btPanel01);		
		plus = new JButton("+");		
		btPanel01.add(plus);
		minus = new JButton("-");
		btPanel01.add(minus);
		
		
		JPanel btPanel02 = new JPanel();	
		btPanel02.setBounds(0, 120, 300, 40);
		add(btPanel02);		
		multiply = new JButton("*");	
		btPanel02.add(multiply);
		divide = new JButton("/");
		btPanel02.add(divide);
				
		
		JPanel resultPanel = new JPanel();
		resultPanel.setBounds(0, 160, 300, 40);
		add(resultPanel);
		JLabel label01 = new JLabel("계산결과 : ");
		label02 = new JLabel("");
		resultPanel.add(label01);
		resultPanel.add(label02);
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setVisible(true);
		
		//익명객체생성
		plus.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				double result = 0.0;
				double no1 = Double.parseDouble(num1.getText());
				double no2 = Double.parseDouble(num2.getText());
				label02.setText(String.valueOf(no1+no2));
			}
		});	
		minus.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				double result = 0.0;
				double no1 = Double.parseDouble(num1.getText());
				double no2 = Double.parseDouble(num2.getText());
				label02.setText(String.valueOf(no1-no2));
			}
		});	
		multiply.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				double result = 0.0;
				double no1 = Double.parseDouble(num1.getText());
				double no2 = Double.parseDouble(num2.getText());
				label02.setText(String.valueOf(no1*no2));
			}
		});
		divide.addActionListener(new ActionListener() {
	
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				double result = 0.0;
				double no1 = Double.parseDouble(num1.getText());
				double no2 = Double.parseDouble(num2.getText());
				label02.setText(String.valueOf(no1/no2));
			}
		});
		
	}
	
	
	
	public static void main(String[] args) {  
		new Cal3();
	}


}