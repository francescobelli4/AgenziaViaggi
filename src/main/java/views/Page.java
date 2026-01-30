package views;

public enum Page {
    STARTUP_ERROR("/pages/StartupErrorPage.fxml"),
    NOTIFICATION("/pages/Notification.fxml"),
    LOGIN("/pages/LoginPage.fxml"),
    HOME("/pages/HomePage.fxml"),
    LISTA_TAPPE("/pages/listatappe/ListaTappe.fxml"),
    LISTA_TAPPE_ELEMENT("/pages/listatappe/ListaTappeElement.fxml"),
    AGGIUNGI_TAPPA("/pages/listatappe/AggiungiTappa.fxml"),
    LISTA_ITINERARI("/pages/listaitinerari/ListaItinerari.fxml"),
    LISTA_ITINERARI_ELEMENT("/pages/listaitinerari/ListaItinerariElement.fxml"),
    AGGIUNGI_ITINERARIO("/pages/listaitinerari/AggiungiItinerario.fxml"),
    AGGIUNGI_ITINERARIO_ELEMENT("/pages/listaitinerari/AggiungiItinerarioTappaElement.fxml"),
    LISTA_TAPPE_PER_ITINERARIO("/pages/listaitinerari/ListaTappePerItinerario.fxml"),
    LISTA_TAPPE_PER_ITINERARIO_ELEMENT("/pages/listaitinerari/ListaTappePerItinerarioElement.fxml"),
    LISTA_ALBERGHI("/pages/listaalberghi/ListaAlberghi.fxml"),
    LISTA_ALBERGHI_ELEMENT("/pages/listaalberghi/ListaAlberghiElement.fxml"),
    ALBERGO_INFO("/pages/listaalberghi/AlbergoInfo.fxml"),
    AGGIUNGI_ALBERGO("/pages/listaalberghi/AggiungiAlbergo.fxml"),
    LISTA_AUTOBUS("/pages/listaautobus/ListaAutobus.fxml"),
    LISTA_AUTOBUS_ELEMENT("/pages/listaautobus/ListaAutobusElement.fxml"),
    AGGIUNGI_AUTOBUS("/pages/listaautobus/AggiungiAutobus.fxml"),
    LISTA_CLIENTI("/pages/listaclienti/ListaClienti.fxml"),
    LISTA_CLIENTI_ELEMENT("/pages/listaclienti/ListaClientiElement.fxml"),
    LISTA_VIAGGI("/pages/listaviaggi/ListaViaggi.fxml"),
    LISTA_VIAGGI_ELEMENT("/pages/listaviaggi/ListaViaggiElement.fxml"),
    AGGIUNGI_VIAGGIO("/pages/listaviaggi/AggiungiViaggio.fxml"),
    AGGIUNGI_VIAGGIO_ITINERARIO_ELEMENT("/pages/listaviaggi/AggiungiViaggioItinerarioElement.fxml"),
    INFO_VIAGGIO("/pages/listaviaggi/InfoViaggio.fxml"),
    INFO_VIAGGIO_TAPPA_ELEMENT("/pages/listaviaggi/InfoViaggioTappaElement.fxml"),
    INFO_VIAGGIO_LISTA_ALBERGHI_PER_CITTA("/pages/listaviaggi/InfoViaggioListaAlberghiPerCittà.fxml"),
    INFO_VIAGGIO_LISTA_ALBERGHI_PER_CITTA_ELEMENT("/pages/listaviaggi/InfoViaggioListaAlberghiPerCittàElement.fxml"),
    INFO_VIAGGIO_AUTOBUS_ELEMENT("/pages/listaviaggi/InfoViaggioAutobusElement.fxml"),
    AGGIUNGI_PRENOTAZIONE("/pages/listaviaggi/AggiungiPrenotazione.fxml"),
    AGGIUNGI_PRENOTAZIONE_ELEMENT("/pages/listaviaggi/AggiungiPrenotazioneElement.fxml"),
    INFO_VIAGGIO_PRENOTAZIONE_ELEMENT("/pages/listaviaggi/InfoViaggioPrenotazioneElement.fxml"),
    DISDICI_PRENOTAZIONE("/pages/DisdiciPrenotazione.fxml"),
    REPORT_VIAGGI("/pages/Report.fxml"),
    REPORT_VIAGGI_ELEMENT("/pages/ReportElement.fxml");

    private final String path;

    Page(String path) {
        this.path = path;
    }

    public String getPath() {
        return this.path;
    }
}
