package views;

public enum Page {
    STARTUP_ERROR("/pages/StartupErrorPage.fxml"),
    NOTIFICATION("/pages/Notification.fxml"),
    LOGIN("/pages/LoginPage.fxml"),
    HOME("/pages/HomePage.fxml"),
    LISTA_TAPPE("/pages/listatappe/ListaTappe.fxml"),
    LISTA_TAPPE_ELEMENT("/pages/listatappe/ListaTappeElement.fxml"),
    AGGIUNGI_TAPPA("/pages/listatappe/AggiungiTappa.fxml");

    private final String path;

    Page(String path) {
        this.path = path;
    }

    public String getPath() {
        return this.path;
    }
}
