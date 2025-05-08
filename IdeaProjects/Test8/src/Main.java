import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //Cerinta 1
        List<Figura> figuri = citireFiguri("FGeom.csv");
        System.out.println("-->Cerinta 1");
        figuri.forEach(System.out::println);

        //Cerinta 2
        List<Figura> cerinta2 = figuri.stream()
                .filter(figura -> figura.getListaPuncte().size() == 4)
                .toList();
        System.out.println("\n-->Cerinta 2. Patrulatere:");
        cerinta2.forEach(System.out::println);

        //Cerinta 3
        System.out.println("\n-->Cerinta 3. Perimetrele:");
        figuri.stream()
                .forEach(figura -> System.out.println(figura.getEticheta() +
                                ": " + figura.calculeazaPerimetru()
                ));

        //Cerinta 4
        System.out.println("\n-->Cerinta 4 <Perimetre.csv>");
        try {
            List<Figura> figuriSortate = figuri.stream()
                    .sorted((f1, f2) -> Double.compare(f2.calculeazaPerimetru(), f1.calculeazaPerimetru()))
                    .toList();

            PrintWriter writer = new PrintWriter(new FileWriter("Perimetre.csv"));
            figuriSortate.forEach(figura ->
                    writer.println(figura.getEticheta() + "," + figura.calculeazaPerimetru())
            );
            writer.close();

            figuriSortate.forEach(figura ->
                    System.out.println(figura.getEticheta() + "," + figura.calculeazaPerimetru())
            );
        } catch (IOException e) {
            System.err.println(e);
        }

        //Cerinta 5
        System.out.println("\n-->Cerinta 5");
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream("Puncte.dat"))) {
            figuri.stream()
                    .flatMap(figura -> figura.getListaPuncte().stream())
                    .forEach(punct -> {
                        try {
                            dos.writeDouble(punct.getX());
                            dos.writeDouble(punct.getY());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });
            System.out.println("Toate punctele au fost salvate in fisierul binar Puncte.dat");
        } catch (IOException e) {
            System.err.println(e);
        }

        //Cerinta 6
        System.out.println("\n-->Cerinta 6");
        List<Punct> puncteCitite = new ArrayList<>();
        try (DataInputStream dis = new DataInputStream(new FileInputStream("Puncte.dat"))) {
            while (dis.available() > 0) {
                double x = dis.readDouble();
                double y = dis.readDouble();
                puncteCitite.add(new Punct(x, y));
            }
            puncteCitite.forEach(System.out::println);
        } catch (IOException e) {
            System.err.println(e);
        }

    }
    private static List<Figura> citireFiguri(String numeFisier) {
        List<Figura> figura = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(numeFisier))) {
            String linie;
            while ((linie = reader.readLine()) != null) {
                String[] parts = linie.split(",");
                String eticheta = parts[0];
                List<Punct> puncte = new ArrayList<>();
                for (int i = 1; i < parts.length; i += 2) {
                    double x = Double.parseDouble(parts[i]);
                    double y = Double.parseDouble(parts[i + 1]);
                    puncte.add(new Punct(x, y));
                }
                figura.add(new Figura(eticheta, puncte));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return figura;
    }
    
}

