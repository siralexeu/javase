package eu.deic.io;

public class ProgMain02while {
    public static void main(String[] args) {
        int size = 5; 
        int i = 1;
        
        while (i <= size) {
            int j = 1;
            while (j <= size) {
                System.out.printf("%4d", i * j);
                j++;
            }
            System.out.println();
            i++;
        }
    }
}
