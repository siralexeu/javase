package eu.deic.io;

public class CarMonitoring {
    public static void main(String[] args) {
        int n = 3; 
        int m = 5; 

        int[][] distanceData = {
            {120, 130, 125, 135, 140}, 
            {110, 115, 120, 125, 130}, 
            {100, 105, 110, 115, 120}
        };

        for (int carIndex = 0; carIndex < n; carIndex++) {
            int totalDistance = 0;
            int maxDistance = Integer.MIN_VALUE;
            int minDistance = Integer.MAX_VALUE;

            for (int dayIndex = 0; dayIndex < m; dayIndex++) {
                int distance = distanceData[carIndex][dayIndex];
                totalDistance += distance;
                
                if (distance > maxDistance) {
                    maxDistance = distance;
                }
                if (distance < minDistance) {
                    minDistance = distance;
                }
            }

            double avgDistance = totalDistance / (double)m;

            System.out.println("Mașina " + (carIndex + 1) + ":");
            System.out.println("Media km/zi: " + avgDistance);
            System.out.println("Maxim km/zi: " + maxDistance);
            System.out.println("Minim km/zi: " + minDistance);
            System.out.println();
        }
    }
}
