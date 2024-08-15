package telran.multithreading;

public class TimerControllerAppl {

	public static void main(String[] args) throws InterruptedException {
		Timer timer = new Timer();
		timer.start();
		Thread.sleep(5000);
		timer.finish();
		Thread.sleep(5000);

	}

}