package eu.deic.io;

public class ParkingLot {
    public static void main(String[] args) {
        int n = 5; 
        int m = 5; 

        int[][] parkingData = {
            {120, 130, 125, 135, 140}, 
            {110, 116, 120, 127, 130}, 
            {100, 105, 110, 125, 120}, 
            {90, 95, 100, 105, 110},   
            {80, 85, 90, 95, 100}      
        };

        for (int parkingSpot = 0; parkingSpot < n; parkingSpot++) {
            int maxTime = Integer.MIN_VALUE;
            int minTime = Integer.MAX_VALUE;

            for (int day = 0; day < m; day++) {
                int time = parkingData[parkingSpot][day];
                maxTime = Math.max(maxTime, time);
                minTime = Math.min(minTime, time);
            }

            System.out.println("Locul de parcare " + (parkingSpot + 1) + ":");
            System.out.println("Timpul maxim: " + maxTime + " minute");
            System.out.println("Timpul minim: " + minTime + " minute");
            System.out.println();
        }
    }
}
