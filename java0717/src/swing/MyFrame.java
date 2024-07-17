package swing;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MyFrame {
	public static void main(String[] args) {
		new MouseListenerEx();
	}
	
}

class MouseListenerEx extends JFrame{
	JPanel jp = new JPanel();	//flowlayout 기본
	JLabel la = new JLabel("No Mouse Event");
	
	MouseListenerEx(){
		this.setContentPane(jp);	//gui컴포넌트들이 부탁되는곳
		jp.add(la);
		this.setSize(700, 500);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		jp.addMouseListener(new MyMouseListener());
		jp.addMouseMotionListener(new MyMouseListener());
	}
	
	class MyMouseListener implements MouseListener, MouseMotionListener{	//implements 다음에는 다중상속이 가능함

		//MouseListener
		@Override
		public void mouseClicked(MouseEvent e) {	//컴포넌트에 이벤트를 주어야함
			la.setText("click("+e.getX() + "," + e.getY()+")");			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			la.setText("press("+e.getX() + "," + e.getY()+")");			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			la.setText("release("+e.getX() + "," + e.getY()+")");			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			jp.setBackground(Color.cyan);		
		}

		@Override
		public void mouseExited(MouseEvent e) {
			jp.setBackground(Color.yellow);		
		}

		//MouseMotionListener
		@Override
		public void mouseDragged(MouseEvent e) {
			la.setText("drag("+e.getX() + "," + e.getY()+")");
		}

		@Override
		public void mouseMoved(MouseEvent e) {
			la.setText("move("+e.getX() + "," + e.getY()+")");
		}
		
	}
}

