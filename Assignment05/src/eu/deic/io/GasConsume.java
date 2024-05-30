package eu.deic.io;

public class GasConsume {
    public static void main(String[] args) {
        double[] litersConsumed = {15.5, 16.0, 14.2, 15.8, 16.5}; 
        double[] costPerLiter = {8.0, 7.5, 7.2, 7.8, 7.0}; 

        double totalLitersConsumed = 0;
        double totalCost = 0;

        for (int i = 0; i < litersConsumed.length; i++) {
            totalLitersConsumed += litersConsumed[i];
            totalCost += litersConsumed[i] * costPerLiter[i];
        }

        double avgLitersConsumed = totalLitersConsumed / litersConsumed.length;
        double avgCostPerDay = totalCost / litersConsumed.length;

        System.out.println("Consum total de combustibil: " + totalLitersConsumed + " litri");
        System.out.println("Consum mediu de combustibil pe zi: " + avgLitersConsumed + " litri");
        System.out.println("Cost total: " + totalCost + " RON");
        System.out.println("Cost mediu pe zi: " + avgCostPerDay + " RON");
    }
}
