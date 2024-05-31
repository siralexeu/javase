package eu.deic.api;

import java.util.Random;

public class Parallel1 {

    public static void main(String[] args) throws InterruptedException {
        Random rand = new Random();
        int n = 10000000; 
        int[] a = new int[n];
        int[] b = new int[n];
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = rand.nextInt(100);
            b[i] = rand.nextInt(100);
        }

        int[] numThreadsOptions = {1, 2, 4, 8, 16, 32};

        for (int numThreads : numThreadsOptions) {
            long startTime = System.nanoTime();
            Parallel1Add.parallelAdd(a, b, result, numThreads);
            long endTime = System.nanoTime();

            System.out.printf("Time taken with %d threads: %.3f ms%n", numThreads, (endTime - startTime) / 1e6);
        }
    }
}

