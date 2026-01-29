package models;

public class Referente {

    private final String CF;
    private final String nome;
    private final String cognome;

    public Referente(String CF, String nome, String cognome) {
        this.CF = CF;
        this.nome = nome;
        this.cognome = cognome;
    }

    public String getCF() {
        return CF;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }
}
