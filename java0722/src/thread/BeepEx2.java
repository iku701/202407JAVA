package thread;

public class BeepEx2 {
	public static void main(String[] args) {
		//소리와 출력 동시에 실행
		Thread thread = new Thread(new BeepTask());
		thread.start();
		
		for(int i = 0; i < 5; i++) {
			System.out.println("띵");
			try {
				Thread.sleep(500);	//1000 = 1초
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
