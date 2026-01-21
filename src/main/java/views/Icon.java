package views;

public enum Icon {

    APPICON("/icons/AppIcon.png"),
    APPNAME("/icons/AppName.png");

    private String path;

    Icon(String path) {
        this.path = path;
    }

    public String getPath() {
        return this.path;
    }
}
