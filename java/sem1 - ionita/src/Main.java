import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        var scanner=new Scanner(System.in);

        System.out.printf("a= ");
        int a = Integer.parseInt(scanner.nextLine());

        System.out.printf("b= ");
        int b = Integer.parseInt(scanner.nextLine());

        System.out.printf("%d + %d = %d%n",a,b,a+b);

        System.out.printf("Nume: ");
        var nume = scanner.nextLine();
        System.out.printf("Hello %s!%n",nume);

    }
}