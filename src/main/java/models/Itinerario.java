package models;

public class Itinerario {

    private final String nome;
    private final int costo;

    public Itinerario(String nome, int costo) {
        this.nome = nome;
        this.costo = costo;
    }

    public String getNome() {
        return nome;
    }

    public int getCosto() {
        return costo;
    }
}
