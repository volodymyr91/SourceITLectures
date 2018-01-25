package homework;

public class ThreadTask1 extends Thread implements Runnable {

	@Override
	public void run() {
		try {
			for (int i = 0; i < 10; i++) {
				System.out.println("name: " + Thread.currentThread().getName());
				Thread.sleep(500);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) throws InterruptedException {
		Thread thread1 = new Thread(new ThreadTask1());
		thread1.start();
		
		new ThreadTask1().start();
	}

}
