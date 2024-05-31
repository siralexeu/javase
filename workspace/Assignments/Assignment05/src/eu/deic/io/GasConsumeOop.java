package eu.deic.io;

public class GasConsumeOop {
    public static void main(String[] args) {
        DailyGasConsumption[] dailyConsumptions = {
            new DailyGasConsumption(15.5, 8.0),
            new DailyGasConsumption(16.0, 7.5),
            new DailyGasConsumption(14.2, 7.2),
            new DailyGasConsumption(15.8, 7.8),
            new DailyGasConsumption(16.5, 7.0)
        };

        double totalLitersConsumed = 0;
        double totalCost = 0;

        for (DailyGasConsumption dailyConsumption : dailyConsumptions) {
            totalLitersConsumed += dailyConsumption.getLitersConsumed();
            totalCost += dailyConsumption.getCost();
        }

        double avgLitersConsumed = totalLitersConsumed / dailyConsumptions.length;
        double avgCostPerDay = totalCost / dailyConsumptions.length;

        System.out.println("Consum total de combustibil: " + totalLitersConsumed + " litri");
        System.out.println("Consum mediu de combustibil pe zi: " + avgLitersConsumed + " litri");
        System.out.println("Cost total: " + totalCost + " RON");
        System.out.println("Cost mediu pe zi: " + avgCostPerDay + " RON");
    }
}

class DailyGasConsumption {
    private double litersConsumed;
    private double costPerLiter;

    public DailyGasConsumption(double litersConsumed, double costPerLiter) {
        this.litersConsumed = litersConsumed;
        this.costPerLiter = costPerLiter;
    }

    public double getLitersConsumed() {
        return litersConsumed;
    }

    public double getCost() {
        return litersConsumed * costPerLiter;
    }
}
