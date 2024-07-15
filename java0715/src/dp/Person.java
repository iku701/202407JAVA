package dp;

public class Person {
	private Phone[] phones; 
	
	//생성자 
	public Person(){
		phones = new Phone[2];  //private Phone[] phones = new Phone[2];
	}
	
	public Phone getPhone(int i) { // 좋지 않은 설계
		if(i == 0 || i == 1) {
			return phones[i]; // 0 일때 집전화,  1일때 회사전화
			
		}
		return null;
	}
}
