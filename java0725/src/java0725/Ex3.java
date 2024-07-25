package java0725;

public class Ex3 {
	public static void main(String[] args) {
		String si = args[0]; 	//커맨드라인 arguments
		System.out.println(si);
		int num = 0;	
		try {
			num = Integer.parseInt(si);
		}catch(NumberFormatException e) {
			e.printStackTrace();
		}
		
	}
}
