package views;

import graphicscontrollers.GraphicsController;
import graphicscontrollers.ReportsElementViewController;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import models.Report;
import utils.Utils;

public class ReportsElementView implements View {

    @FXML
    private HBox root;
    @FXML
    private Label codiceLabel;
    @FXML
    private Label itinerarioLabel;
    @FXML
    private Label entrateLabel;
    @FXML
    private Label usciteLabel;
    @FXML
    private Label guadagnoLabel;

    private static final Page page = Page.REPORT_VIAGGI_ELEMENT;
    private final GraphicsController<ReportsElementView> graphicsController;

    public ReportsElementView(Report report) {
        this.graphicsController = new ReportsElementViewController(this, report);
        init();
    }

    @Override
    public void init() {
        Utils.scaleFonts(root);
    }

    public Label getCodiceLabel() {
        return codiceLabel;
    }

    public Label getEntrateLabel() {
        return entrateLabel;
    }

    public Label getGuadagnoLabel() {
        return guadagnoLabel;
    }

    public Label getItinerarioLabel() {
        return itinerarioLabel;
    }

    public Label getUsciteLabel() {
        return usciteLabel;
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
    public GraphicsController<ReportsElementView> getGraphicsController() {
        return graphicsController;
    }
}
