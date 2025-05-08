package seminar.seminar2.g1059;

public class Revista extends Publicatie {
    private String colectie;
    private int aparitiiAn;

    public Revista() {
    }

    public Revista(String titlu, Domeniu[] domenii, String cota, double valoareInventar, int anAparitie, String cultura, String editura, String colectie, int aparitiiAn) throws Exception {
        super(titlu, domenii, cota, valoareInventar, anAparitie, cultura, editura);
        this.colectie = colectie;
        this.aparitiiAn = aparitiiAn;
    }

    public Revista(String cota) {
        super(cota);
    }

    public String getColectie() {
        return colectie;
    }

    public void setColectie(String colectie) {
        this.colectie = colectie;
    }

    public int getAparitiiAn() {
        return aparitiiAn;
    }

    public void setAparitiiAn(int aparitiiAn) {
        this.aparitiiAn = aparitiiAn;
    }

    @Override
    public String toString() {
        return super.toString()+ "\nRevista{" +
                "," + colectie + '\'' +
                "," + aparitiiAn +
                '}';
    }
}
