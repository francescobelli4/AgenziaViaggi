package models;

public class Cliente {

    private final String cf;
    private final String nome;
    private final String cognome;

    public Cliente(String cf, String nome, String cognome) {
        this.nome = nome;
        this.cf = cf;
        this.cognome = cognome;
    }

    public String getNome() {
        return nome;
    }

    public String getCf() {
        return cf;
    }

    public String getCognome() {
        return cognome;
    }
}
