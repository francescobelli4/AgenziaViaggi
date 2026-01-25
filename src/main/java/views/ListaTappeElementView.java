package views;

import graphicscontrollers.GraphicsController;
import graphicscontrollers.ListaTappeElementViewController;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import models.Tappa;
import utils.Utils;

public class ListaTappeElementView implements View {

    @FXML
    private HBox root;
    @FXML
    private ImageView iconImageView;
    @FXML
    private Label stopLabel;
    @FXML
    private Button stopActionButton;
    @FXML
    private Button deleteButton;

    private static final Page page = Page.LISTA_TAPPE_ELEMENT;
    private final GraphicsController<ListaTappeElementView> graphicsController;

    public ListaTappeElementView(Tappa tappa) {
        this.graphicsController = new ListaTappeElementViewController(this, tappa);
        init();
    }

    @Override
    public void init() {
        Utils.scaleFonts(root);
    }

    public ImageView getIconImageView() {
        return iconImageView;
    }

    public Label getStopLabel() {
        return stopLabel;
    }

    public Button getStopActionButton() {
        return stopActionButton;
    }

    public Button getDeleteButton() {
        return deleteButton;
    }

    @Override
    public void close() {
        //Nothing to do...
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
    public GraphicsController<ListaTappeElementView> getGraphicsController() {
        return graphicsController;
    }
}
