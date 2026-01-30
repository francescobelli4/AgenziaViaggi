package models;

public class Albergo {

    private final String nome;
    private final String indirizzo;
    private final String citta;
    private final int costo;
    private final int capienza;
    private final Referente referente;
    private final String email;
    private final String telefono;
    private final String fax;

    public Albergo(String nome, String indirizzo, String citta, int costo, int capienza, Referente referente, String email, String telefono, String fax) {
        this.nome = nome;
        this.indirizzo = indirizzo;
        this.citta = citta;
        this.costo = costo;
        this.capienza = capienza;
        this.referente = referente;
        this.email = email;
        this.telefono = telefono;
        this.fax = fax;
    }

    public Albergo(String nome, String indirizzo, String citta) {
        this(nome, indirizzo, citta, -1, -1, null, "", "", "");
    }

    public String getNome() {
        return nome;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public String getCitta() {
        return citta;
    }

    public int getCosto() {
        return costo;
    }

    public int getCapienza() {
        return capienza;
    }

    public Referente getReferente() {
        return referente;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getFax() {
        return fax;
    }
}
