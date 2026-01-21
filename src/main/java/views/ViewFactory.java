package views;

public class ViewFactory {

    private ViewFactory () {}

    public static LoginView createLoginView() {
        return new LoginView();
    }
}