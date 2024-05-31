package eu.deic.oop;

public class Student {
    private int nrMatricol;
    private String nume;
    private int[] marks;
    private float avg;

    public Student(int nrMat, String nume, int[] marks) {
        this.nrMatricol = nrMat;
        this.nume = nume;
        this.marks = marks;
        this.avg = 0.0f; // Inițializează media la 0.0
    }
    
    public float getAvg() {
        float sum = 0;
        for (int mark : marks) {
            sum += mark;
        }
        this.avg = sum / marks.length;
        return this.avg;
    }
}
