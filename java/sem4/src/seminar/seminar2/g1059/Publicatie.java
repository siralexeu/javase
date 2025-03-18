package seminar.seminar2.g1059;

import java.util.Arrays;
import java.util.Objects;

public abstract class Publicatie implements Comparable<Publicatie>{
    protected String titlu, cota, cultura;
    protected String editura;
    protected int anAparitie;
    protected double valoareInventar;
    protected Domeniu[] domenii;

    public Publicatie() {
    }

    public Publicatie(String titlu, Domeniu[] domenii, String cota, double valoareInventar, int anAparitie, String cultura, String editura) throws Exception {
        if (anAparitie > 2025) {
            throw new Exception("An aparitie invalid");
        }
        this.titlu = titlu;
        this.domenii = domenii;
        this.cota = cota;
        this.valoareInventar = valoareInventar;
        this.anAparitie = anAparitie;
        this.cultura = cultura;
        this.editura = editura;
    }

    public Publicatie(String cota) {
        this.cota = cota;
    }

    public String getTitlu() {
        return titlu;
    }

    public void setTitlu(String titlu) {
        this.titlu = titlu;
    }


    public String getCultura() {
        return cultura;
    }

    public void setCultura(String cultura) {
        this.cultura = cultura;
    }

    public int getAnAparitie() {
        return anAparitie;
    }

    public void setAnAparitie(int anAparitie) throws Exception {
        if (anAparitie > 2025) {
            throw new Exception("An aparitie invalid");
        }
        this.anAparitie = anAparitie;
    }

    public double getValoareInventar() {
        return valoareInventar;
    }

    public void setValoareInventar(double valoareInventar) {
        this.valoareInventar = valoareInventar;
    }

    public Domeniu[] getDomenii() {
        return domenii;
    }

    public void setDomenii(Domeniu[] domenii) {
        this.domenii = domenii;
    }

    public String getCota() {
        return cota;
    }

    public void setCota(String cota) {
        this.cota = cota;
    }

    public String getEditura() {
        return editura;
    }

    public void setEditura(String editura) {
        this.editura = editura;
    }

    @Override
    public String toString() {
        return /*super.toString()+*/ "\nPublicatie{"
                    + titlu + '\'' +
                "," + cota + '\'' +
                "," + editura + '\'' +
                "," + anAparitie +
                "," + valoareInventar +
                "," + Arrays.toString(domenii) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Publicatie that = (Publicatie) o;
        return Objects.equals(cota, that.cota);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(cota);
    }

    @Override
    public int compareTo(Publicatie o) {
        return Integer.compare(this.anAparitie, o.anAparitie);
    }
}
