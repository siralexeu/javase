package eu.deic.io;

public class ProgMain01 {
    public static void main(String[] args) {
        // Datele pentru fiecare stare de depunere și intervale de venituri
        int[][] brackets = {
            {8375, 34000, 82250, 171850, 373650},  // Single
            {8350, 33950, 68525, 104625, 186825},  // Married Filing Separately
            {16750, 68000, 137300, 209250, 373650},  // Married Filing Jointly
            {11950, 45550, 117650, 190550, 373650}  // Head of Household
        };

        // Venituri pentru fiecare stare de depunere
        int[] incomes = {40000, 80000, 120000, 200000};

        // Calculul impozitului pentru fiecare stare de depunere și venit
        for (int i = 0; i < brackets.length; i++) {
            System.out.println(getFilingStatus(i) + ":");
            for (int j = 0; j < incomes.length; j++) {
                double tax = calculateTax(brackets[i], incomes[j]);
                System.out.println("Impozit pentru venitul de " + incomes[j] + " dolari: " + tax + " dolari");
            }
            System.out.println();
        }
    }

    // Funcția pentru a determina starea de depunere pe baza indicelui
    public static String getFilingStatus(int index) {
        String[] statuses = {"Single", "Married Filing Separately", "Married Filing Jointly", "Head of Household"};
        return statuses[index];
    }

    // Funcția pentru a calcula impozitul pe venit pentru o stare de depunere și un venit dat
    public static double calculateTax(int[] bracket, int income) {
        double tax = 0;
        int[] rates = {10, 15, 25, 28, 33, 35};
        for (int i = 0; i < bracket.length; i++) {
            if (income <= bracket[i]) {
                tax += income * rates[i] / 100.0;
                break;
            } else {
                tax += bracket[i] * rates[i] / 100.0;
                income -= bracket[i];
            }
        }
        return tax;
    }
}
