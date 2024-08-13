package telran.multithreading;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Timer extends Thread {
	private DateTimeFormatter timeFormat;
	private long resolution;
	private volatile boolean running = true;

	public Timer(String timePattern, long resolutionMillis) {
		this.timeFormat = DateTimeFormatter.ofPattern(timePattern);
		this.resolution = resolutionMillis;
		setDaemon(true);
	}

	@Override
	public void run() {
		while (running) {
			System.out.println(LocalTime.now().format(timeFormat));
			try {
				sleep(resolution);
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
				running = false; 
			}
		}
	}

	public void stopTimer() {
		running = false;
	}
}
