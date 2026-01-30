package views;

import graphicscontrollers.GraphicsController;
import graphicscontrollers.InfoViaggioTappaElementViewController;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import models.Tappa;
import utils.Utils;

public class InfoViaggioTappaElementView implements View {

    @FXML
    private HBox root;
    @FXML
    private ImageView iconImageView;
    @FXML
    private Label stopLabel;

    private static final Page page = Page.INFO_VIAGGIO_TAPPA_ELEMENT;
    private final GraphicsController<InfoViaggioTappaElementView> graphicsController;

    public InfoViaggioTappaElementView(Tappa tappa) {
        this.graphicsController = new InfoViaggioTappaElementViewController(this, tappa);
        init();
    }

    @Override
    public void init() {
        Utils.scaleFonts(root);
    }

    public Label getStopLabel() {
        return stopLabel;
    }

    public ImageView getIconImageView() {
        return iconImageView;
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
    public GraphicsController<InfoViaggioTappaElementView> getGraphicsController() {
        return graphicsController;
    }
}
