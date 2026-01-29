package views;

import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Screen;
import javafx.stage.Stage;
import models.Albergo;
import models.Itinerario;

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

    public static void displayAggiungiTappaView() {
        ((StackPane)activeView.getRoot()).getChildren().add(ViewFactory.createAggiungiTappaView().getRoot());
    }

    public static void displayListaTappePerItinerarioView(Itinerario itinerario) {
        ((StackPane)activeView.getRoot()).getChildren().add(ViewFactory.createListaTappePerItinerarioView(itinerario).getRoot());
    }

    public static void displayAggiungiItinerarioView() {
        ((StackPane)activeView.getRoot()).getChildren().add(ViewFactory.createAggiungiItinerarioView().getRoot());
    }

    public static void displayAlbergoInfoView(Albergo albergo) {
        ((StackPane)activeView.getRoot()).getChildren().add(ViewFactory.createAlbergoInfoView(albergo).getRoot());
    }

    public static void displayAggiungiAlbergoView() {
        ((StackPane)activeView.getRoot()).getChildren().add(ViewFactory.createAggiungiAlbergoView().getRoot());
    }

    public static void displayAggiungiAutobusView() {
        ((StackPane)activeView.getRoot()).getChildren().add(ViewFactory.createAggiungiAutobusView().getRoot());
    }

    public static void displayAggiungiViaggioView() {
        ((StackPane)activeView.getRoot()).getChildren().add(ViewFactory.createAggiungiViaggioView().getRoot());
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
