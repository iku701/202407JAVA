package templateMethod;

public class StringDisplay extends AbstractDisplay{
	private String string;
	private int width;
	
	public StringDisplay(String string2) {
		// TODO Auto-generated constructor stub
	}

	public void setString(String string) {
		this.string = string;
	}
	
	public void setWidth(int width) {
		this.width = width;
	}
	
	//open과 close에서 호출되어 "+----+" 문자열을 표시하는 메소드
	private void printLine() {
		System.out.print("+");
		for (int i = 0; i < width; i++) {
			System.out.print("-");
		}
		System.out.println("+");
	}
	
	@Override
	public void open() {
		// TODO Auto-generated method stub
		printLine();
	}
	@Override
	public void print() {
		// TODO Auto-generated method stub
		System.out.println("|" + string + "|");
	}
	@Override
	public void close() {
		// TODO Auto-generated method stub
		printLine();
	}
	
	
}
