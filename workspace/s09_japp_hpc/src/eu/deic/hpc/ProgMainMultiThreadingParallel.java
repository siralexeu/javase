package eu.deic.hpc;

class RArray implements Runnable {
	private int[] v1; private int[] v2; private int[] vout;
	private int startI; private int stopI;
	public RArray(int[] array1, int [] array2, int[] arrayResult, int startIdx, int stopIdx) {
		this.v1 = array1;
		this.v2 = array2;
		this.vout = arrayResult;
		this.startI = startIdx;
		this.stopI = stopIdx;
	}
    @Override
    public void run() {
		for (var i = startI; i <= stopI; i++) {
			this.vout[i] = this.v1[i] + this.v2[i];
		}
    }//end run
}//end RArray class

public class ProgMainMultiThreadingParallel {
	public static void main(String[] args) {
		int NTH = 8;
		int adim = 40_000_000;
		int[] a1 = new int[adim];
		int[] a2 = new int[adim];
		int[] aout = new int[adim];
		//cati mega bytes am ocupat, adica in heap 120 000 000 * 4 bytes = 480 000 000 bytes = 480 MB
		
		long startT = 0, stopT = 0;
		int startIdx = 0, stopIdx = 0;
		for (var i = 0; i < adim; i++) {
			a1[i] = (i+1); a2[i] = (adim - i); aout[i] = 0;
		}
		//1. seq
		startT = System.currentTimeMillis();
		for (var i = 0; i < adim; i++)
			aout[i] = a1[i] + a2[i];
		stopT = System.currentTimeMillis();
		System.out.println("1. seq ms = " + (stopT - startT) + ", aout-first = " + aout[0] + ", aout-last = " + aout[adim - 1]);
		
		//2. std. multi-threading
		for (var i = 0; i < adim; i++) {
			a1[i] = (i+1); a2[i] = (adim - i); aout[i] = 0;
		}
		startT = System.currentTimeMillis();
		RArray[] ra = new RArray[NTH];
		Thread[] ta = new Thread[NTH];
		for(var it = 0; it < NTH; it++) {
			startIdx = it * (adim / NTH);
			stopIdx = (it + 1) * (adim / NTH) - 1;
			ra[it] = new RArray(a1, a2, aout, startIdx, stopIdx);
			ta[it] = new Thread(ra[it]);
		}
		for(var it = 0; it < NTH; it++) 
			ta[it].start();
		for(var it = 0; it < NTH; it++) {
			try {
				ta[it].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		stopT = System.currentTimeMillis();
		System.out.println("2. std. hpc ms = " + (stopT - startT) + ", aout-first = " + aout[0] + ", aout-last = " + aout[adim - 1]);
		
		
	}//end main method

}// end main class

