package views;

import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Screen;
import javafx.stage.Stage;

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
