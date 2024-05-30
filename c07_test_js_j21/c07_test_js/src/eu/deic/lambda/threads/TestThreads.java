package eu.deic.lambda.threads;

// https://github.com/critoma/javase/blob/master/labs/s08_japp_multithreads_concurrency/src/eu/ase/threads/TestThreads.java

class HelloThread extends Thread {
	public HelloThread(String name) {
		super(name);
	}

	@Override
	public void run() {
		String name = Thread.currentThread().getName();
		System.out.println("Hello " + name);
	}
}

class HelloRunnable extends /* OtherClass */ Object implements Runnable {
	@Override
	public void run() {
		String name = Thread.currentThread().getName();
		System.out.println("Hello " + name);
	}
}

public class TestThreads {
	public static void main(String[] args) {
		System.out.println("CPU cores = " + Runtime.getRuntime().availableProcessors());
		
		HelloThread tJ5 = new HelloThread("Th01 Java 1.1 ... 21");
		// tJ5.run();
		tJ5.start();
//		try { tJ5.join(); } catch (InterruptedException e) {
//			e.printStackTrace();
//		}

		HelloRunnable tJ5Plus = new HelloRunnable();
		Thread tw_tJ5Plus = new Thread(tJ5Plus, "Th02 Java 1.1 Plus ... 21");
		tw_tJ5Plus.start();

		Runnable taskJ7 = new Runnable() {
			@Override
			public void run() {
				String name = Thread.currentThread().getName();
				System.out.println("Hello J7 " + name);
			}
		};

		Thread twj7 = new Thread(taskJ7, "Th03 Java 7 ... 21 ");
		twj7.start();

		Runnable taskJ8 = () -> {
			String name = Thread.currentThread().getName();
			System.out.println("Hello J8 " + name);
		};

		Thread twj8 = new Thread(taskJ8, "Th04 Java 8 ... 21");
		twj8.start();
	}
}
