package telran.multithreading;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Timer extends Thread {
private static final String DEFAULT_FORMATTER_PATTERN = "HH.mm.ss";
private static final long DEFAULT_TIMER_RESOLUTION = 1000;
private volatile boolean running = true;
private DateTimeFormatter dtf;
private long timerResolution;
	public Timer(String pattern, long timerResolution) {
		dtf = DateTimeFormatter.ofPattern(pattern);
		this.timerResolution = timerResolution;
		setDaemon(true);
	}
	public Timer() {
		this(DEFAULT_FORMATTER_PATTERN, DEFAULT_TIMER_RESOLUTION);
	}
	public void run() {
		while(running) {
			System.out.println(LocalTime.now().format(dtf));
			try {
				sleep(timerResolution);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public void finish() {
		running = false;
	}
}