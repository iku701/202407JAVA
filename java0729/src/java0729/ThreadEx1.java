package java0729;

public class ThreadEx1 {
	public static void main(String[] args) {
		Thread mThred = Thread.currentThread();
		System.out.println(mThred.getName());
		
		ThreadA threadA = new ThreadA();
		threadA.start();
		
		
		
		Thread threadB = new Thread() {
			

			@Override
			public void run() {
				
				
				for (int i = 0; i < 2; i++) {
					System.out.println(this.getName());
					try {
						Thread.sleep(100); 		//스레드가 쉬는동안에 다른 스레드가 일할 여지를 주기위함
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}	
			}
			
		};
		threadB.setName("ThreadB");
		threadB.start();
		
		Thread threadC = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				for (int i = 0; i < 2; i++) {
					System.out.println(Thread.currentThread().getName());
				}	
			}
		});
		
		threadC.setName("ThreadC");
		threadC.start();
		
	}
}
