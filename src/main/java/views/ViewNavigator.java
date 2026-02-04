package views;

import graphicscontrollers.AggiungiTappaViewController;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Screen;
import javafx.stage.Stage;
import models.Albergo;
import models.Itinerario;
import models.Tappa;
import models.Viaggio;

public class ViewNavigator {

    private ViewNavigator() {}

    private static Stage stage;
    private static Scene scene;
    private static View activeView;

    public static void setStage(Stage primaryStage) {
        stage = primaryStage;

        scene = new Scene(new StackPane());
        stage.setScene(scene);
    }

    public static void closeCurrentFloatingPage() {
        ((StackPane)activeView.getRoot()).getChildren().removeLast();
    }

    public static void displayLoginView() {
        activeView = ViewFactory.createLoginView();
        scene.setRoot(activeView.getRoot());
    }

    public static void displayStartupErrorView(String title, String description) {
        activeView = ViewFactory.createStartupErrorView(title, description);
        scene.setRoot(activeView.getRoot());
    }

    public static void displayNotification(String title, String description, Icon icon) {
        ((StackPane)activeView.getRoot()).getChildren().add(ViewFactory.createNotificationView(title, description, icon).getRoot());
    }

    public static void displayHomeView() {
        activeView = ViewFactory.createHomeView();
        scene.setRoot(activeView.getRoot());
    }

    public static AggiungiTappaView displayAggiungiTappaView() {
        AggiungiTappaView aggiungiTappaView = ViewFactory.createAggiungiTappaView();
        ((StackPane)activeView.getRoot()).getChildren().add(aggiungiTappaView.getRoot());
        return aggiungiTappaView;
    }

    public static void displayListaTappePerItinerarioView(Itinerario itinerario) {
        ((StackPane)activeView.getRoot()).getChildren().add(ViewFactory.createListaTappePerItinerarioView(itinerario).getRoot());
    }

    public static AggiungiItinerarioView displayAggiungiItinerarioView() {
        AggiungiItinerarioView aggiungiItinerarioView = ViewFactory.createAggiungiItinerarioView();
        ((StackPane)activeView.getRoot()).getChildren().add(aggiungiItinerarioView.getRoot());
        return aggiungiItinerarioView;
    }

    public static void displayAlbergoInfoView(Albergo albergo) {
        ((StackPane)activeView.getRoot()).getChildren().add(ViewFactory.createAlbergoInfoView(albergo).getRoot());
    }

    public static AggiungiAlbergoView displayAggiungiAlbergoView() {
        AggiungiAlbergoView aggiungiAlbergoView = ViewFactory.createAggiungiAlbergoView();
        ((StackPane)activeView.getRoot()).getChildren().add(aggiungiAlbergoView.getRoot());
        return aggiungiAlbergoView;
    }

    public static AggiungiAutobusView displayAggiungiAutobusView() {
        AggiungiAutobusView aggiungiAutobusView = ViewFactory.createAggiungiAutobusView();
        ((StackPane)activeView.getRoot()).getChildren().add(aggiungiAutobusView.getRoot());
        return aggiungiAutobusView;
    }

    public static AggiungiViaggioView displayAggiungiViaggioView() {
        AggiungiViaggioView aggiungiViaggioView = ViewFactory.createAggiungiViaggioView();
        ((StackPane)activeView.getRoot()).getChildren().add(aggiungiViaggioView.getRoot());
        return aggiungiViaggioView;
    }

    public static void displayInfoViaggioView(Viaggio viaggio) {
        ((StackPane)activeView.getRoot()).getChildren().add(ViewFactory.createInfoViaggioView(viaggio).getRoot());
    }

    public static void displayDisdiciPrenotazioneView() {
        ((StackPane)activeView.getRoot()).getChildren().add(ViewFactory.createDisdiciPrenotazioneView().getRoot());
    }

    public static InfoViaggioListaAlberghiPerCittaView displayInfoViaggioListaAlberghiPerCittaView(Tappa citta) {
        InfoViaggioListaAlberghiPerCittaView view = ViewFactory.createInfoViaggioListaAlberghiPerCittaView(citta);
        ((StackPane)activeView.getRoot()).getChildren().add(view.getRoot());
        return view;
    }

    public static AggiungiPrenotazioneView displayAggiungiPrenotazioneView(Viaggio viaggio) {
        AggiungiPrenotazioneView view = ViewFactory.createAggiungiPrenotazioneView(viaggio);
        ((StackPane)activeView.getRoot()).getChildren().add(view.getRoot());
        return view;
    }



    public static Stage getStage() {
        return stage;
    }

    public static View getActiveView() {
        return activeView;
    }

    public static double scaleValue(double val) {

        Screen screen = Screen.getPrimary();

        // Windows usually has 1.25 scale
        double scale = screen.getOutputScaleY();
        // Converting screen bounds height to real pixel height
        double phys = screen.getBounds().getHeight() * scale;
        // I built the UI using a 1920x1200 res
        return val * (phys/1200);
    }
}
