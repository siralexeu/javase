package eu.deic.io;

public class StudentMarkOop {
    public static void main(String[] args) {
        StudentClass[] classes = {
            new StudentClass(new double[][] {{8.5, 9.0, 7.8}, {7.0, 8.2, 9.5}}),
            new StudentClass(new double[][] {{9.5, 8.7, 8.0}, {8.0, 8.5, 9.2}}),
            new StudentClass(new double[][] {{8.0, 7.5, 8.2}, {7.2, 8.1, 9.0}}),
            new StudentClass(new double[][] {{9.0, 8.5, 7.8}, {8.2, 7.9, 8.6}}),
            new StudentClass(new double[][] {{7.5, 8.0, 7.2}, {8.1, 8.5, 8.8}})
        };

        double[] classAvgs = new double[classes.length];
        double totalAvg = 0;

        for (int i = 0; i < classes.length; i++) {
            classAvgs[i] = classes[i].calculateAverage();
            totalAvg += classAvgs[i];
        }

        totalAvg /= classes.length;

        System.out.println("Note medii pe clasa:");
        for (int i = 0; i < classAvgs.length; i++) {
            System.out.println("Clasa " + (i + 1) + ": " + classAvgs[i]);
        }

        System.out.println("Nota medie pentru intregul an: " + totalAvg);
    }
}

class StudentClass {
    private double[][] studentGrades;

    public StudentClass(double[][] studentGrades) {
        this.studentGrades = studentGrades;
    }

    public double calculateAverage() {
        double classSum = 0;
        for (int i = 0; i < studentGrades.length; i++) {
            double studentSum = 0;
            for (int j = 0; j < studentGrades[i].length; j++) {
                studentSum += studentGrades[i][j];
            }
            classSum += studentSum / studentGrades[i].length;
        }
        return classSum / studentGrades.length;
    }
}

