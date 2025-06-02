package javaLearning;

public class ThreadWaitAndSleep {
	private static final Object lock = new Object();

	static class WaitingThread extends Thread {
		public void run() {
			synchronized (lock) {
				try {
					System.out.println("Thread 1: Waiting for notification...");
					lock.wait(); // Releases lock and waits
					System.out.println("Thread 1: Resumed after notification");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	static class NotifyingThread extends Thread {
		public void run() {
			synchronized (lock) {
				System.out.println("Thread 2: Sending notification...");
				lock.notify(); // Notifies waiting thread
			}
		}
	}

	public static void main(String[] args) {
		WaitingThread t1 = new WaitingThread();
		NotifyingThread t2 = new NotifyingThread();

		t1.start(); // Start Thread 1
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
		} // Ensure Thread 1 starts first
		t2.start(); // Start Thread 2 (which calls notify)
	}
}