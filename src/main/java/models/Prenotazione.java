package models;

import java.util.Map;

public class Prenotazione {

    private final String viaggio;
    private final String codicePrenotazione;
    private final Map<String, Cliente> clienti;

    public Prenotazione(String viaggio, String codicePrenotazione, Map<String, Cliente> clienti) {
        this.viaggio = viaggio;
        this.codicePrenotazione = codicePrenotazione;
        this.clienti = clienti;
    }

    public Map<String, Cliente> getClienti() {
        return clienti;
    }

    public String getCodicePrenotazione() {
        return codicePrenotazione;
    }

    public String getViaggio() {
        return viaggio;
    }
}
