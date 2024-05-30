package eu.deic.io;

public class StudentMark {
    public static void main(String[] args) {
        double[][][] classGrades = {
            {
                {8.5, 9.0, 7.8}, 
                {7.0, 8.2, 9.5}, 
            },
            {
                {9.5, 8.7, 8.0}, 
                {8.0, 8.5, 9.2}, 
            },
            {
                {8.0, 7.5, 8.2}, 
                {7.2, 8.1, 9.0}, 
            },
            {
                {9.0, 8.5, 7.8}, 
                {8.2, 7.9, 8.6}, 
            },
            {
                {7.5, 8.0, 7.2}, 
                {8.1, 8.5, 8.8}, 
            }
        };

        double[] classAvgs = new double[classGrades.length];
        double totalAvg = 0;

        for (int i = 0; i < classGrades.length; i++) {
            double classSum = 0;
            for (int j = 0; j < classGrades[i].length; j++) {
                double studentSum = 0;
                for (double grade : classGrades[i][j]) {
                    studentSum += grade;
                }
                classSum += studentSum / classGrades[i][j].length;
            }
            classAvgs[i] = classSum / classGrades[i].length;
            totalAvg += classAvgs[i];
        }

        totalAvg /= classGrades.length;

        System.out.println("Note medii pe clasa:");
        for (int i = 0; i < classAvgs.length; i++) {
            System.out.println("Clasa " + (i + 1) + ": " + classAvgs[i]);
        }

        System.out.println("Nota medie pentru intregul an: " + totalAvg);
    }
}
