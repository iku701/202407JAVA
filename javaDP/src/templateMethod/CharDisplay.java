package templateMethod;

public class CharDisplay extends AbstractDisplay{
	private char ch; //표시해야하는 문자
	
	//생성자
	public CharDisplay(char ch) {
		this.ch = ch;
	}
	@Override
	public void open() {
		// TODO Auto-generated method stub
		System.out.println("<<");
	}

	@Override
	public void print() {
		// TODO Auto-generated method stub
		System.out.println(ch);
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub
		System.out.println(">>");
	}
	

}
