package seminar.seminar1.g1065;

import java.util.Arrays;
import java.util.DoubleSummaryStatistics;
import java.util.Scanner;

public class Main {

    private static double[][] note;
    private static String[] grupe;
    private static double[] medii;
    private static double mediaGenerala;

    public static void main(String[] args) throws Exception {
//        System.out.println("Seminar 1 1065");
//        for(String arg:args){
//            System.out.println(arg);
//        }
        if (args.length != 3) {
            throw new Exception("Numar incorect de parametrii");
        }
        if (!"SI".contains(args[2].toUpperCase())) {
            throw new Exception("Tip invalid");
        }
        int n = Integer.parseInt(args[0]);
        double valoare = Double.parseDouble(args[1]);
        String tip = args[2];
        double[][] x = init(n, valoare, tip);
        print(x, "Matricea input: ");

        x = adaugare(x, 2);
        print(x, "Matricea exinsta cu 2 linii/coloane: ");

        try {
            x = eliminare(x, 4);
            print(x, "Matricea redusa cu 2 linii/coloane: ");
        } catch (Exception e) {
            System.err.println(e);
        }

        //Cerinta 3
        citireDate();
        for (int i = 0; i < grupe.length; i++) {
            System.out.println(grupe[i] + "," + medii[i]);
        }
        System.out.println("Media generala: " + mediaGenerala);
    }

    private static void print(double[][] x, String msg) {
        System.out.println(msg);
        for (double[] linie : x) {
            System.out.println(Arrays.toString(linie));
        }
    }

    private static double[][] init(int n, double v, String tip) {
        double[][] x = new double[n][n];
        if (tip.equalsIgnoreCase("s")) {
            for (int i = 0; i < n - 1; i++) {
                Arrays.fill(x[i], i + 1, n, v);
            }
        } else {
            for (int i = 1; i < n; i++) {
                Arrays.fill(x[i], 0, i, v);
            }
        }

        return x;
    }

    private static double[][] adaugare(double[][] x, int n) {
        double v = x[1][0] != 0 ? x[1][0] : x[0][1];
        String tip = x[1][0] != 0 ? "i" : "s";
        return init(x.length + n, v, tip);
    }

    private static double[][] eliminare(double[][] x, int n) throws Exception {
        if (n > x.length - 2) {
            throw new Exception("Numarul de linii de eliminat este prea mare");
        }
        double v = x[1][0] != 0 ? x[1][0] : x[0][1];
        String tip = x[1][0] != 0 ? "i" : "s";
        return init(x.length - n, v, tip);
    }

    private static void citireDate() {
        try (Scanner scanner = new Scanner(System.in)) {
            int n = Integer.parseInt(scanner.nextLine().trim());
            note = new double[n][];
            grupe = new String[n];
            medii = new double[n];
            DoubleSummaryStatistics sumatorNote = new DoubleSummaryStatistics();
            for (int i = 0; i < n; i++) {
                String[] linie = scanner.nextLine().trim().split(",");
                DoubleSummaryStatistics sumatorGrupa = new DoubleSummaryStatistics();
                grupe[i] = linie[0].trim();
                note[i] = new double[linie.length - 1];
                for (int j = 0; j < note[i].length; j++) {
                    note[i][j] = Double.parseDouble(linie[j + 1].trim());
                    sumatorNote.accept(note[i][j]);
                    sumatorGrupa.accept(note[i][j]);
                }
                medii[i] = sumatorGrupa.getAverage();
            }
            mediaGenerala = sumatorNote.getAverage();
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}
