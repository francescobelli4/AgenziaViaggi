package views;

public class ViewFactory {

    private ViewFactory () {}

    public static LoginView createLoginView() {
        return new LoginView();
    }

    public static StartupErrorView createStartupErrorView(String title, String description) {
        return new StartupErrorView(title, description);
    }
}