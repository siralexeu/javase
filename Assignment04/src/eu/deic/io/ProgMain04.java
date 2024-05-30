package eu.deic.io;

public class ProgMain04 {
    public static void main(String[] args) {
        Matrix a = new Matrix(2, 2);
        a.set(0, 0, 8);
        a.set(0, 1, 4);
        a.set(1, 0, 5);
        a.set(1, 1, 7);

        Matrix b = new Matrix(2, 2);
        b.set(0, 0, 3);
        b.set(0, 1, 5);
        b.set(1, 0, 5);
        b.set(1, 1, 3);

        Matrix sum = Matrix.multiply(a, b);

        System.out.println("Matricea a:");
        a.print();
        System.out.println("Matricea b:");
        b.print();
        System.out.println("Inmultirea matricelor:");
        sum.print();
        
    }// end  main
    
}// end class ProgMain04

