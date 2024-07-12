package java0712;

public class Factorial1 {
	
	public static int fac2(int n) {          //자기자신을 호출하는 메서드(재귀호출 recursive)
		if(n == 0) {
			return 1;
		}else {
			return n * fac2(n-1);
		}
	}
	
	public static int fac(int n) {
		int res = 1; 
		for(int i = 0; i < n; i++) {
			res *= i;
		}
		return res;
	}
	
	
	public static void main(String[] args) {
		int num = 4;
		int result = fac(num);
		System.out.println(result);
	}
	
	
}
