package views;

import models.Itinerario;
import models.Tappa;

public class ViewFactory {

    private ViewFactory () {}

    public static LoginView createLoginView() {
        return new LoginView();
    }

    public static StartupErrorView createStartupErrorView(String title, String description) {
        return new StartupErrorView(title, description);
    }

    public static NotificationView createNotificationView(String title, String description, Icon icon) {
        return new NotificationView(title, description, icon);
    }

    public static HomeView createHomeView() {
        return new HomeView();
    }

    public static ListaTappeView createListaTappeView() {
        return new ListaTappeView();
    }

    public static ListaTappeElementView createListaTappeElementView(Tappa tappa) {
        return new ListaTappeElementView(tappa);
    }

    public static AggiungiTappaView createAggiungiTappaView() {
        return new AggiungiTappaView();
    }

    public static ListaItinerariView createListaItinerariView() {
        return new ListaItinerariView();
    }

    public static ListaItinerariElementView createListaItinerariElementView(Itinerario itinerario) {
        return new ListaItinerariElementView(itinerario);
    }

    //public static AggiungiTappaView createAggiungiTappaView() {
    //    return new AggiungiTappaView();
    //}
}