package telran.multithreading;

import java.time.LocalTime;

public class Timer extends Thread {
	//TODO 
	public Timer() {
		setDaemon(true);
	}
	public void run() {
		while(true) {
			System.out.println(LocalTime.now());
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
