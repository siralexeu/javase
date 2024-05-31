package eu.deic.multithreading;

class HelloThread extends Thread {
	public HelloThread(String nameOfThread) {
		super(nameOfThread);
	}
	@Override
	public void run() {
		System.out.println("HelloThread - name = " + Thread.currentThread().getName() + ", id = " +Thread.currentThread().getId());
	}
}//end class HelloThread

class HelloRunnable extends Object implements Runnable {
	private String nameTh;
	public HelloRunnable(String nameOfThread) {
		this.nameTh = nameOfThread;
	}
	@Override
	public void run() {
		System.out.println("HelloThread - name = " + Thread.currentThread().getName() + ", id = " +Thread.currentThread().getId());
	}
}//end class HelloRunnable

public class ProgMainTest {

	public static void main(String[] args) {
		Thread objTh01 = new HelloThread("f1"); //HelloThread objTh01 = new HelloThread("f1");
		((HelloThread) objTh01).start();

		Runnable objR02 = new HelloRunnable("f2"); //HelloRunnable objR02 = new HelloRunnable("f2");
		Thread objTh02 = new Thread(objR02);
		objTh02.start();
		
		Runnable objR03 = () -> {
				System.out.println("Runnable lambda - name = " + Thread.currentThread().getName() + ", id = " +Thread.currentThread().getId());
		};
		Thread objTh03 = new Thread(objR03);
		objTh03.start();
		
		System.out.println("Main thread finished!");
	}//end main method

}//end maiin class
