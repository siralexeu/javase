package eu.deic.io;

import java.util.Random;

public class ProgMain03 {
    public static void main(String[] args) {
        int numElements = 100;
        int[] numbers = new int[numElements];
        Random rand = new Random();

        for (int i = 0; i < numElements; i++) {
            numbers[i] = rand.nextInt(1000);
        }

        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }

        double average = (double) sum / numElements;

        int countAboveAverage = 0;
        for (int number : numbers) {
            if (number > average) {
                countAboveAverage++;
            }
        }

        System.out.println("Media nr: " + average);
        System.out.println("Nr peste medie: " + countAboveAverage);
    }
}

