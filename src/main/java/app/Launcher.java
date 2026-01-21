package app;

import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.stage.Screen;
import javafx.stage.Stage;
import views.Icon;
import views.ViewNavigator;

import java.util.Objects;
import java.util.logging.Logger;

public class Launcher extends Application {

    private static final Logger LOGGER = Logger.getLogger("Launcher");

    public static void initialize() {
        Launcher.launch();
    }

    @Override
    public void start(Stage primaryStage) {
        LOGGER.info("Starting application!");

        Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
        primaryStage.setMinHeight(screenBounds.getHeight());
        primaryStage.setMinWidth(screenBounds.getWidth()/2);

        primaryStage.setMaxHeight(screenBounds.getHeight());
        primaryStage.setMaxWidth(screenBounds.getWidth());

        primaryStage.setHeight(screenBounds.getHeight());
        primaryStage.setWidth(screenBounds.getWidth());

        primaryStage.setTitle("TripHunter");
        primaryStage.getIcons().clear();
        primaryStage.getIcons().add(new Image(Objects.requireNonNull(getClass().getResourceAsStream(Icon.APPICON.getPath()))));

        ViewNavigator.setStage(primaryStage);
        primaryStage.show();
    }
}
