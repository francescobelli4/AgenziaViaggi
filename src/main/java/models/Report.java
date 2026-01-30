package models;

public class Report {

    private final String codiceViaggio;
    private final String itinerario;
    private final int entrate;
    private final int uscite;
    private final int guadagno;

    public Report(String codiceViaggio, String itinerario, int entrate, int uscite, int guadagno) {
        this.codiceViaggio = codiceViaggio;
        this.itinerario = itinerario;
        this.entrate = entrate;
        this.uscite = uscite;
        this.guadagno = guadagno;
    }

    public String getItinerario() {
        return itinerario;
    }

    public int getEntrate() {
        return entrate;
    }

    public int getGuadagno() {
        return guadagno;
    }

    public int getUscite() {
        return uscite;
    }

    public String getCodiceViaggio() {
        return codiceViaggio;
    }
}
