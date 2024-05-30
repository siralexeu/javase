package eu.deic.api;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Parallel5 {
    public static List<int[]> readMatrixConcurrently(String filePath, int numThreads) throws Exception {
        List<Future<int[]>> futures = new ArrayList<>();
        ExecutorService executor = Executors.newFixedThreadPool(numThreads);

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                final String currentLine = line;
                futures.add(executor.submit(new Callable<int[]>() {
                    @Override
                    public int[] call() {
                        String[] parts = currentLine.trim().split("\\s+");
                        int[] row = new int[parts.length];
                        for (int i = 0; i < parts.length; i++) {
                            row[i] = Integer.parseInt(parts[i]);
                        }
                        return row;
                    }
                }));
            }
        }

        executor.shutdown();

        List<int[]> matrix = new ArrayList<>();
        for (Future<int[]> future : futures) {
            matrix.add(future.get());
        }
        return matrix;
    }

    public static void main(String[] args) {
        try {
            List<int[]> matrix = readMatrixConcurrently("resultMatrix.txt", 4); 
            for (int[] row : matrix) {
                for (int num : row) {
                    System.out.print(num + " ");
                }
                System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
