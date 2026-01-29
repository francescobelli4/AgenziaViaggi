package models;

import java.time.LocalDate;

public class Viaggio {

    private final String codice;
    private final String itinerario;
    private final LocalDate partenza;
    private final LocalDate ritorno;

    public Viaggio(String codice, String itinerario, LocalDate partenza, LocalDate ritorno) {
        this.codice = codice;
        this.itinerario = itinerario;
        this.partenza = partenza;
        this.ritorno = ritorno;
    }

    public LocalDate getPartenza() {
        return partenza;
    }

    public LocalDate getRitorno() {
        return ritorno;
    }

    public String getCodice() {
        return codice;
    }

    public String getItinerario() {
        return itinerario;
    }
}

