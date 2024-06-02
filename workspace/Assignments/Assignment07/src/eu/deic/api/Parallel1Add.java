package eu.deic.api;

import java.util.concurrent.*;

public class Parallel1Add {
    public static void parallelAdd(int[] a, int[] b, int[] result, int numThreads) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(numThreads);
        int chunkSize = (a.length + numThreads - 1) / numThreads;


        for (int i = 0; i < numThreads; i++) {
            final int start = i * chunkSize;
            final int end = Math.min(start + chunkSize, a.length);
            executor.submit(() -> {
                for (int j = start; j < end; j++) {
                    result[j] = a[j] + b[j];
                }
            });
        }
        
        executor.shutdown(); 
        executor.awaitTermination(1, TimeUnit.HOURS); 
    }
}
