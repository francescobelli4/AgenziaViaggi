package views;

public enum Icon {

    APPICON("/icons/AppIcon.png"),
    APPNAME("/icons/AppName.png"),
    APPNAMEBG("/icons/AppNameBG.png"),
    CITY("/icons/city.png"),
    HOTEL("/icons/hotel.png"),
    LOCATION("/icons/location.png"),
    MORE("/icons/more.png");

    private String path;

    Icon(String path) {
        this.path = path;
    }

    public String getPath() {
        return this.path;
    }
}
