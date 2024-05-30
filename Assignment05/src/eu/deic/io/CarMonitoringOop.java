package eu.deic.io;

public class CarMonitoringOop {
    public static void main(String[] args) {
        // int n = 3;
        // int m = 5;

        int car1Day1 = 120, car1Day2 = 130, car1Day3 = 125, car1Day4 = 135, car1Day5 = 140;
        int car2Day1 = 110, car2Day2 = 115, car2Day3 = 120, car2Day4 = 125, car2Day5 = 130;
        int car3Day1 = 100, car3Day2 = 105, car3Day3 = 110, car3Day4 = 115, car3Day5 = 120;

        calculateAndPrintStatistics("Mașina 1", car1Day1, car1Day2, car1Day3, car1Day4, car1Day5);
        calculateAndPrintStatistics("Mașina 2", car2Day1, car2Day2, car2Day3, car2Day4, car2Day5);
        calculateAndPrintStatistics("Mașina 3", car3Day1, car3Day2, car3Day3, car3Day4, car3Day5);
    }

    public static void calculateAndPrintStatistics(String carName, int... distances) {
        int totalDistance = 0;
        int maxDistance = Integer.MIN_VALUE;
        int minDistance = Integer.MAX_VALUE;

        for (int distance : distances) {
            totalDistance += distance;
            if (distance > maxDistance) {
                maxDistance = distance;
            }
            if (distance < minDistance) {
                minDistance = distance;
            }
        }

        double avgDistance = totalDistance / (double) distances.length;

        System.out.println(carName + ":");
        System.out.println("Media km/zi: " + avgDistance);
        System.out.println("Maxim km/zi: " + maxDistance);
        System.out.println("Minim km/zi: " + minDistance);
        System.out.println();
    }
}
