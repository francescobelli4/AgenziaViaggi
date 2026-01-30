package views;

import graphicscontrollers.GraphicsController;
import graphicscontrollers.InfoViaggioAutobusElementViewController;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import models.Autobus;
import utils.Utils;

public class InfoViaggioAutobusElementView implements View {

    @FXML
    private HBox root;
    @FXML
    private Label targaLabel;
    @FXML
    private Label costLabel;
    @FXML
    private Label capienzaLabel;
    @FXML
    private CheckBox checkBox;

    private static final Page page = Page.INFO_VIAGGIO_AUTOBUS_ELEMENT;
    private final GraphicsController<InfoViaggioAutobusElementView> graphicsController;

    public InfoViaggioAutobusElementView(Autobus autobus) {
        this.graphicsController = new InfoViaggioAutobusElementViewController(this, autobus);
        init();
    }

    @Override
    public void init() {
        Utils.scaleFonts(root);
    }

    public Label getTargaLabel() {
        return targaLabel;
    }

    public Label getCapienzaLabel() {
        return capienzaLabel;
    }

    public Label getCostoLabel() {
        return costLabel;
    }

    public CheckBox getCheckBox() {
        return checkBox;
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
    public GraphicsController<InfoViaggioAutobusElementView> getGraphicsController() {
        return graphicsController;
    }
}
