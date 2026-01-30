package views;

import models.*;

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

    public static ListaTappePerItinerarioView createListaTappePerItinerarioView(Itinerario itinerario) {
        return new ListaTappePerItinerarioView(itinerario);
    }

    public static ListaTappePerItinerarioElementView createListaTappePerItinerarioElementView(Tappa tappa) {
        return new ListaTappePerItinerarioElementView(tappa);
    }

    public static AggiungiItinerarioView createAggiungiItinerarioView() {
        return new AggiungiItinerarioView();
    }

    public static AggiungiItinerarioTappaElementView createAggiungiItinerarioTappaElementView(Tappa tappa) {
        return new AggiungiItinerarioTappaElementView(tappa);
    }

    public static ListaAlberghiView createListaAlberghiView() {
        return new ListaAlberghiView();
    }

    public static ListaAlberghiElementView createListaAlberghiElementView(Albergo albergo) {
        return new ListaAlberghiElementView(albergo);
    }

    public static AlbergoInfoView createAlbergoInfoView(Albergo albergo) {
        return new AlbergoInfoView(albergo);
    }

    public static AggiungiAlbergoView createAggiungiAlbergoView() {
        return new AggiungiAlbergoView();
    }

    public static ListaAutobusView createListaAutobusView() {
        return new ListaAutobusView();
    }

    public static ListaAutobusElementView createListaAutobusElementView(Autobus autobus) {
        return new ListaAutobusElementView(autobus);
    }

    public static AggiungiAutobusView createAggiungiAutobusView() {
        return new AggiungiAutobusView();
    }

    public static ListaClientiView createListaClientiView() {
        return new ListaClientiView();
    }

    public static ListaClientiElementView createListaClientiElementView(Cliente cliente) {
        return new ListaClientiElementView(cliente);
    }

    public static ListaViaggiView createListaViaggiView() {
        return new ListaViaggiView();
    }

    public static ListaViaggiElementView createListaViaggiElementView(Viaggio viaggio) {
        return new ListaViaggiElementView(viaggio);
    }

    public static AggiungiViaggioView createAggiungiViaggioView() {
        return new AggiungiViaggioView();
    }

    public static AggiungiViaggioItinerarioElementView createAggiungiViaggioItinerarioElementView(Itinerario itinerario) {
        return new AggiungiViaggioItinerarioElementView(itinerario);
    }

    public static InfoViaggioView createInfoViaggioView(Viaggio viaggio) {
        return new InfoViaggioView(viaggio);
    }

    public static InfoViaggioTappaElementView createInfoViaggioTappaElementView(Tappa tappa) {
        return new InfoViaggioTappaElementView(tappa);
    }

    public static InfoViaggioListaAlberghiPerCittaView createInfoViaggioListaAlberghiPerCittaView(Tappa citta) {
        return new InfoViaggioListaAlberghiPerCittaView(citta);
    }

    public static InfoViaggioListaAlberghiPerCittaElementView createInfoViaggioListaAlberghiPerCittaElementView(Albergo albergo) {
        return new InfoViaggioListaAlberghiPerCittaElementView(albergo);
    }

    public static InfoViaggioAutobusElementView createInfoViaggioAutobusElementView(Autobus autobus) {
        return new InfoViaggioAutobusElementView(autobus);
    }

    public static AggiungiPrenotazioneView createAggiungiPrenotazioneView(Viaggio viaggio) {
        return new AggiungiPrenotazioneView(viaggio);
    }

    public static AggiungiPrenotazioneElementView createAggiungiPrenotazioneElementView() {
        return new AggiungiPrenotazioneElementView();
    }

    public static InfoViaggioPrenotazioneElementView createInfoViaggioPrenotazioneElementView(String codicePrenotazione, String codiceDisdetta, Cliente cliente) {
        return new InfoViaggioPrenotazioneElementView(codicePrenotazione, codiceDisdetta, cliente);
    }

    public static DisdiciPrenotazioneView createDisdiciPrenotazioneView() {
        return new DisdiciPrenotazioneView();
    }

    public static ReportsView createReportsView() {
        return new ReportsView();
    }

    public static ReportsElementView createReportsElementView(Report report) {
        return new ReportsElementView(report);
    }
}