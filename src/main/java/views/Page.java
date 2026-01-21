package views;

public enum Page {
    STARTUP_ERROR("/pages/StartupErrorPage.fxml"),
    LOGIN("/pages/LoginPage.fxml");

    private final String path;

    Page(String path) {
        this.path = path;
    }

    public String getPath() {
        return this.path;
    }
}
