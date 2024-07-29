package java0729;

//p.503
public	class Ex2{
	public static void main(String[] args) {
		long time = System.nanoTime();
		System.out.println(time);
		
		for (int i = 0; i < 1000000000; i++) {
			
		}
		long time2 = System.nanoTime();
		System.out.println(time2-time);
	}
}