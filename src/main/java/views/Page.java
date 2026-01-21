package views;

public enum Page {
    LOGIN("/pages/LoginPage.fxml");

    private String path;

    Page(String path) {
        this.path = path;
    }

    public String getPath() {
        return this.path;
    }
}
