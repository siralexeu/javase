package eu.deic.multithreading;

//class ThreadNonSynch extends Thread {
class ThreadSynch extends Thread {
	
	private static int a = 0;
	private static int b = 0;
	private static Object objMutexLocker = new Object();
	
	//public ThreadNonSynch(String tName) {
	public ThreadSynch(String tName) {
		super(tName);
	}
	
	public void myMethod() {}
	
	@Override
	public void run() {
		synchronized(objMutexLocker) {
		for(int i = 0; i < 3; i++) {
			
			System.out.println("Thread = " + this.getName()+" ; a = " + a + " , b = " + b);
			a++;
			try {
				sleep((int)Math.random() * 1000);
			} catch(InterruptedException iex) {
				iex.printStackTrace();
			}
			b++;
		  }//end synch 1
		}//end for	
	}//end run
}//end thread class


public class ProgMainMultiThreads {
	public static void main(String[] args) {
		//ThreadNonSynch f1 = new ThreadNonSynch("f1");
		//ThreadNonSynch f2 = new ThreadNonSynch("f2");
	ThreadSynch f1 = new ThreadSynch("f1");
	ThreadSynch f2 = new ThreadSynch("f2");
	
	
		f1.start();
		f2.start();
		System.out.println("Main Program finished!");
}

}
