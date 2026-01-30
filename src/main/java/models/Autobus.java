package models;

public class Autobus {

    private final String targa;
    private final int costo;
    private final int capienza;

    public Autobus(String targa, int costo, int capienza) {
        this.targa = targa;
        this.costo = costo;
        this.capienza = capienza;
    }

    public int getCosto() {
        return costo;
    }

    public String getTarga() {
        return targa;
    }

    public int getCapienza() {
        return capienza;
    }
}
