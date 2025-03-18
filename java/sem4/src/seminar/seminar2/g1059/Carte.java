package seminar.seminar2.g1059;

import java.util.Arrays;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Carte extends Publicatie implements Cloneable,Operatiuni {
    private String[] autori;
    private int nrPagini;
    private Sala salaRezervare;
    private Date dataReturnare;

    public Carte() {
    }

    public Carte(String titlu, Domeniu[] domenii, String cota, double valoareInventar, int anAparitie, String cultura, String editura, String[] autori, int nrPagini) throws Exception {
        super(titlu, domenii, cota, valoareInventar, anAparitie, cultura, editura);
        this.autori = autori;
        this.nrPagini = nrPagini;
    }

    public Carte(String cota) {
        super(cota);
    }

    public String[] getAutori() {
        return autori;
    }

    public void setAutori(String[] autori) {
        this.autori = autori;
    }

    public int getNrPagini() {
        return nrPagini;
    }

    public void setNrPagini(int nrPagini) {
        this.nrPagini = nrPagini;
    }

    public Sala getSalaRezervare() {
        return salaRezervare;
    }

    public void setSalaRezervare(Sala salaRezervare) {
        this.salaRezervare = salaRezervare;
    }

    public Date getDataReturnare() {
        return dataReturnare;
    }

    public void setDataReturnare(Date dataReturnare) {
        this.dataReturnare = dataReturnare;
    }

    @Override
    public String toString() {
        return super.toString()+ "\nCarte{" +
                Arrays.toString(autori) +
                "," + nrPagini +
                "," + salaRezervare +
                "," + (dataReturnare!=null ? "Carte imprumutata: " + Main.formatData.format(dataReturnare) : " ") +
                '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Carte clona = (Carte)super.clone();
        if(autori!=null){
            clona.setAutori(autori.clone());
        }
        if(domenii!=null){
            clona.setDomenii(domenii.clone());
        }
        if(dataReturnare !=null){
            clona.setDataReturnare((Date) dataReturnare.clone());
        }
        return clona;
    }

    @Override
    public void imprumut(long nrZile) {
        if(dataReturnare==null && salaRezervare==null){
            Date dataCurenta = new Date();
            dataReturnare = new Date(dataCurenta.getTime() + TimeUnit.DAYS.toMillis(nrZile));
        } else {
            System.err.println("Carte la sala sau imprumutata!");
        }
    }

    @Override
    public void rezervareSala(Sala numeSala) {
        if(dataReturnare==null && salaRezervare==null){
            salaRezervare = numeSala;
        } else {
            System.err.println("Carte la sala sau imprumutata!");
        }
    }

    @Override
    public void returnare() {
        Date dataCurenta = new Date();
        if(dataReturnare.before(dataCurenta)){
            long depasire = TimeUnit.MILLISECONDS.toDays(dataCurenta.getTime()-dataReturnare.getTime());
            System.err.println("Depasire cu " + depasire + " zile");
            dataReturnare = null;
        }
    }

    public void addAutor(String autor){
        if(autori==null){
            autori = new String[0];
        }
        String[] autori = new String[this.autori.length+1];
        System.arraycopy(this.autori,0,autori,0,this.autori.length);
        autori[autori.length-1] = autor;
        this.autori = autori;
    }
}
