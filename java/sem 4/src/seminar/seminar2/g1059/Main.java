package seminar.seminar2.g1059;

import java.io.BufferedReader;
import java.io.FileReader;
import java.text.SimpleDateFormat;

public class Main {
    public static SimpleDateFormat formatData = new SimpleDateFormat("dd.MM.yyyy");
    private static Carte[] carti;
    public static void main(String[] args) {
        try{
            Carte carte = new Carte(
                    "Istoria Romaniei",
                    new Domeniu[]{Domeniu.ISTORIE},
                    "III32571526",
                    150,
                    2009,
                    "Istorie",
                    "Polirom",
                    new String[]{"Theodor Mommsen"},
                    220
            );
            System.out.println(carte);
            Carte carte1 = new Carte();
            System.out.println(carte.equals(carte1));

            Carte carte2 = new Carte(carte.cota);
            System.out.println(carte.equals(carte2));

            System.out.println(carte.compareTo(carte1));

            Carte clona = (Carte) carte.clone();
            carte.getAutori()[0] = "Alt autor";
            System.out.println("Obiect carte:\n" + carte);
            System.out.println("Clona obiect carte:\n" + clona);

            carte.imprumut(25);
            System.out.println("Carte imprumutata:\n" + carte);

            Carte carte3 = new Carte("I87654545");
            carte3.setDataReturnare(formatData.parse("10.03.2025"));
            carte3.returnare();
            carte3.rezervareSala(Sala.VICTOR_SLAVESCU);
            System.out.println("Carte rezervata:\n" + carte3);
            carte3.addAutor("Popescu Ion");
            carte3.addAutor("Ionescu Diana");
            System.out.println(carte3);

            //Citire carti
            carti = citireCarti();
            System.out.println("Carti citite din fisier:");
            for(Carte c:carti){
                System.out.println(c);
            }

        } catch (Exception e) {
            System.err.println(e);
        }
    }
    private static Carte[] citireCarti(){
        try(BufferedReader in = new BufferedReader(new FileReader("carti.csv"))){
            int n = Integer.parseInt(in.readLine());
            carti = new Carte[n];
            //String[] linie;
            for (int i = 0; i < n; i++) {
                String[] linie = in.readLine().split(",");
                Carte carte = new Carte();
                carte.setTitlu(linie[0].trim());
                carte.setCota(linie[1].trim());
                carte.setEditura(linie[2].trim());
                carte.setAnAparitie(Integer.parseInt(linie[3].trim()));
                carte.setValoareInventar(Double.parseDouble(linie[4].trim()));
                String[] domeniiSir = linie[5].trim().split("/");
                Domeniu[] domenii = new Domeniu[domeniiSir.length];
                for (int j = 0; j < domenii.length; j++) {
                    domenii[j] = Domeniu.valueOf(domeniiSir[j].trim().toUpperCase());
                }
                carte.setDomenii(domenii);
                carte.setAutori(linie[6].trim().split("/"));
                carte.setNrPagini(Integer.parseInt(linie[7].trim()));
                carti[i] = carte;
            }
        }catch (Exception e){
            System.err.println(e);
        }
        return carti;
    }
}
