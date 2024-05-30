package eu.deic.io;

public class ProgMain01Oop {
    public static void main(String[] args) {
        // Definirea unui obiect pentru fiecare stare de depunere
        TaxBracket single = new TaxBracket("Single", new int[]{8375, 34000, 82250, 171850, 373650});
        TaxBracket marriedSeparately = new TaxBracket("Married Filing Separately", new int[]{8350, 33950, 68525, 104625, 186825});
        TaxBracket marriedJointly = new TaxBracket("Married Filing Jointly", new int[]{16750, 68000, 137300, 209250, 373650});
        TaxBracket headOfHousehold = new TaxBracket("Head of Household", new int[]{11950, 45550, 117650, 190550, 373650});

        // Venituri pentru fiecare stare de depunere
        int[] incomes = {40000, 80000, 120000, 200000};

        // Calculul impozitului pentru fiecare stare de depunere și venit
        TaxBracket[] brackets = {single, marriedSeparately, marriedJointly, headOfHousehold};
        for (TaxBracket bracket : brackets) {
            System.out.println(bracket.getFilingStatus() + ":");
            for (int income : incomes) {
                double tax = bracket.calculateTax(income);
                System.out.println("Impozit pentru venitul de " + income + " dolari: " + tax + " dolari");
            }
            System.out.println();
        }
    }
}

class TaxBracket {
    private String filingStatus;
    private int[] brackets;

    public TaxBracket(String filingStatus, int[] brackets) {
        this.filingStatus = filingStatus;
        this.brackets = brackets;
    }

    public String getFilingStatus() {
        return filingStatus;
    }

    public double calculateTax(int income) {
        double tax = 0;
        int[] rates = {10, 15, 25, 28, 33, 35};
        for (int i = 0; i < brackets.length; i++) {
            if (income <= brackets[i]) {
                tax += income * rates[i] / 100.0;
                break;
            } else {
                tax += brackets[i] * rates[i] / 100.0;
                income -= brackets[i];
            }
        }
        return tax;
    }
}
