package eu.deic.api;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.Random;

public class Parallel2 {
    public static long parallelDotProduct(int[] a, int[] b, int numThreads) throws InterruptedException {
        final AtomicLong result = new AtomicLong(0);
        ExecutorService executor = Executors.newFixedThreadPool(numThreads);
        int chunkSize = (a.length + numThreads - 1) / numThreads;

        for (int i = 0; i < numThreads; i++) {
            final int start = i * chunkSize;
            final int end = Math.min(start + chunkSize, a.length);
            executor.submit(() -> {
                long sum = 0;
                for (int j = start; j < end; j++) {
                    sum += (long) a[j] * b[j];
                }
                result.addAndGet(sum);
            });
        }
        
        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.HOURS);
        return result.get();
    }

    public static void main(String[] args) throws InterruptedException {
        Random rand = new Random();
        int n = 10000000; // Size of the vectors
        int[] a = new int[n];
        int[] b = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = rand.nextInt(100);
            b[i] = rand.nextInt(100);
        }

        int[] numThreadsOptions = {1, 2, 4, 8, 16, 32};

        for (int numThreads : numThreadsOptions) {
            long startTime = System.nanoTime();
            long result = parallelDotProduct(a, b, numThreads);
            long endTime = System.nanoTime();
            System.out.printf("Dot product with %d threads: %d, Time: %.3f ms%n", numThreads, result, (endTime - startTime) / 1e6);
        }
    }
}
