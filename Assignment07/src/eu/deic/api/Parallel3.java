package eu.deic.api;

import java.io.*;
import java.util.concurrent.*;

public class Parallel3 {
    public static void addMatrices(String inputFile1, String inputFile2, String outputFile, int numThreads) throws IOException, InterruptedException {
        int[][] matrix1 = readMatrixFromFile(inputFile1);
        int[][] matrix2 = readMatrixFromFile(inputFile2);
        int[][] result = new int[matrix1.length][matrix1[0].length];

        ExecutorService executor = Executors.newFixedThreadPool(numThreads);
        for (int row = 0; row < matrix1.length; row++) {
            final int r = row;
            executor.submit(() -> {
                for (int col = 0; col < matrix1[r].length; col++) {
                    result[r][col] = matrix1[r][col] + matrix2[r][col];
                }
            });
        }

        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.HOURS);
        writeMatrixToFile(result, outputFile);
    }

    private static int[][] readMatrixFromFile(String file) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            return reader.lines().map(line -> {
                String[] values = line.trim().split("\\s+");
                return java.util.Arrays.stream(values).mapToInt(Integer::parseInt).toArray();
            }).toArray(int[][]::new);
        }
    }

    private static void writeMatrixToFile(int[][] matrix, String file) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            for (int[] row : matrix) {
                for (int val : row) {
                    writer.write(val + " ");
                }
                writer.newLine();
            }
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        String inputFile1 = "matrix1.txt";
        String inputFile2 = "matrix2.txt";
        String outputFile = "resultMatrix.txt";
        addMatrices(inputFile1, inputFile2, outputFile, 8); 
        System.out.println("The results have been written to " + outputFile);
    }
}
