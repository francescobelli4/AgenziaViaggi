package views;

import graphicscontrollers.GraphicsController;
import graphicscontrollers.StartupErrorViewController;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.StackPane;
import utils.Utils;

public class StartupErrorView implements View {

    @FXML
    private StackPane root;
    @FXML
    private Label title;
    @FXML
    private TextArea description;
    @FXML
    private Button exitButton;

    private final String titleLabel;
    private final String descriptionLabel;

    private static final Page page = Page.STARTUP_ERROR;
    private final GraphicsController<StartupErrorView> graphicsController;

    public StartupErrorView(String title, String description) {
        this.titleLabel = title;
        this.descriptionLabel = description;

        graphicsController = new StartupErrorViewController(this);
        init();
    }

    @Override
    public void init() {
        Utils.scaleFonts(root);

        title.setText(titleLabel);
        description.setText(descriptionLabel);
    }

    @Override
    public void close() {
        // Nothing to do in the view...
    }

    public Button getExitButton() {
        return exitButton;
    }

    @Override
    public Parent getRoot() {
        return root;
    }

    @Override
    public Page getPage() {
        return page;
    }

    @Override
    public GraphicsController<StartupErrorView> getGraphicsController() {
        return graphicsController;
    }
}
