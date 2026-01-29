package dtos;

public record AlbergoDTO(String name, String citta, String indirizzo, int costo, int capacita, String email, String telefono, String fax, String CFReferente, String nomeReferente, String cognomeReferente) {

    public AlbergoDTO(String name, String citta, String indirizzo) {
        this(name, citta, indirizzo, 0, 0, "", "", "", "", "", "");
    }
}
