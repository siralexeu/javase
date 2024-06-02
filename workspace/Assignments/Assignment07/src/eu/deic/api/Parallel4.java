package eu.deic.api;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class Parallel4 {

    public static List<Integer> parallelRowSum(int[][] matrix, int numThreads) throws Exception {
        ExecutorService executor = Executors.newFixedThreadPool(numThreads);
        List<Future<Integer>> results = new ArrayList<>();

        for (int[] row : matrix) {
            Callable<Integer> task = () -> {
                int sum = 0;
                for (int value : row) {
                    sum += value;
                }
                return sum;
            };
            results.add(executor.submit(task));
        }

        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.HOURS);

        List<Integer> sums = new ArrayList<>();
        for (Future<Integer> result : results) {
            sums.add(result.get());
        }
        return sums;
    }

    public static void main(String[] args) throws Exception {
        Random rand = new Random();
        int rows = 1000;
        int cols = 1000;
        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = rand.nextInt(100);
            }
        }

        int[] numThreadsOptions = {1, 2, 4, 8, 16, 32};
        for (int numThreads : numThreadsOptions) {
            long startTime = System.nanoTime();
            List<Integer> sums = parallelRowSum(matrix, numThreads);
            long endTime = System.nanoTime();
            System.out.printf("Time taken with %d threads: %.3f ms%n", numThreads, (endTime - startTime) / 1e6);
        }
    }
}
