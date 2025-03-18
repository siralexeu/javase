package seminar.seminar2.gr1065;

public enum Moneda {
    LEU(1), EURO(2), DOLAR(3);
    private int codValuta;

    Moneda(int codValuta) {
        this.codValuta = codValuta;
    }

    public int getCodValuta() {
        return codValuta;
    }

    public void setCodValuta(int codValuta) {
        this.codValuta = codValuta;
    }
}
