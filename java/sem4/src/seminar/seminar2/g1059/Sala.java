package seminar.seminar2.g1059;

public enum Sala {
    VICTOR_SLAVESCU("Bibloteca Centrala"), GRIGORE_MOISIL("Facultatea de Matematica");
    private String unitate;

    Sala(String unitate) {
        this.unitate = unitate;
    }

    public String getUnitate() {
        return unitate;
    }

    public void setUnitate(String unitate) {
        this.unitate = unitate;
    }
}
