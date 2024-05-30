package eu.deic.io;

public class ParkingLotOop {
    private int[][] parkingData;

    public ParkingLotOop(int[][] parkingData) {
        this.parkingData = parkingData;
    }

    public void findMaxAndMinTimeForEachSpot() {
        int n = parkingData.length; // Numărul de locuri de parcare
        int m = parkingData[0].length; // Numărul de zile monitorizate

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

    public static void main(String[] args) {
        int[][] parkingData = {
            {120, 130, 125, 135, 140}, // Locul de parcare 1
            {110, 116, 120, 127, 130}, // Locul de parcare 2
            {100, 105, 110, 125, 120}, // Locul de parcare 3
            {90, 95, 100, 105, 110},   // Locul de parcare 4
            {80, 85, 90, 95, 100}      // Locul de parcare 5
        };

        ParkingLotOop parkingLotOop = new ParkingLotOop(parkingData);
        parkingLotOop.findMaxAndMinTimeForEachSpot();
    }
}
