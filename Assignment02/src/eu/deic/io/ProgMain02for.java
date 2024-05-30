package eu.deic.io;

public class ProgMain02for {
    public static void main(String[] args) {
        int size = 5; 
        
        for (int i = 1; i <= size; i++) {
            for (int j = 1; j <= size; j++) {
                System.out.printf("%4d", i * j);
            }
            System.out.println();
        }
    }
}
