import java.util.List;

public class Figura {
    private String eticheta;
    private List<Punct> listaPuncte;

    public Figura(String eticheta, List<Punct> listaPuncte) {
        this.eticheta = eticheta;
        this.listaPuncte = listaPuncte;
    }

    public String getEticheta() {
        return eticheta;
    }

    public void setEticheta(String eticheta) {
        this.eticheta = eticheta;
    }

    public List<Punct> getListaPuncte() {
        return listaPuncte;
    }

    public void setListaPuncte(List<Punct> listaPuncte) {
        this.listaPuncte = listaPuncte;
    }

    @Override
    public String toString() {
        return eticheta +"," + listaPuncte ;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public double calculeazaPerimetru() {
        double perimetru = 0;
        for(int i = 0; i < listaPuncte.size(); i++) {
            Punct p1 = listaPuncte.get(i);
            Punct p2 = listaPuncte.get((i + 1) % listaPuncte.size());
            perimetru += Math.sqrt(
                    Math.pow(p1.getX() - p2.getX(), 2) +
                            Math.pow(p1.getY() - p2.getY(), 2)
            );
        }
        return perimetru;
    }
}
