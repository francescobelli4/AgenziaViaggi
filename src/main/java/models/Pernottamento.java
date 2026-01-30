package models;

public class Pernottamento {

    private final Albergo albergo;
    private final int ordine;

    public Pernottamento(Albergo albergo, int ordine) {
        this.albergo = albergo;
        this.ordine = ordine;
    }

    public Albergo getAlbergo() {
        return albergo;
    }

    public int getOrdine() {
        return ordine;
    }
}
