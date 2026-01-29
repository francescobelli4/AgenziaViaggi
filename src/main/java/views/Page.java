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
    LISTA_CLIENTI_ELEMENT("/pages/listaclienti/ListaClientiElement.fxml");

    private final String path;

    Page(String path) {
        this.path = path;
    }

    public String getPath() {
        return this.path;
    }
}
