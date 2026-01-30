package views;

import graphicscontrollers.GraphicsController;
import graphicscontrollers.InfoViaggioListaAlberghiPerCittaElementViewController;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import models.Albergo;
import utils.Utils;

public class InfoViaggioListaAlberghiPerCittaElementView implements View {

    @FXML
    private HBox root;
    @FXML
    private Label hotelLabel;
    @FXML
    private Label costLabel;
    @FXML
    private Label capienzaLabel;

    private static final Page page = Page.INFO_VIAGGIO_LISTA_ALBERGHI_PER_CITTA_ELEMENT;
    private final GraphicsController<InfoViaggioListaAlberghiPerCittaElementView> graphicsController;

    public InfoViaggioListaAlberghiPerCittaElementView(Albergo albergo) {
        this.graphicsController = new InfoViaggioListaAlberghiPerCittaElementViewController(this, albergo);
        init();
    }

    @Override
    public void init() {
        Utils.scaleFonts(root);
    }

    public Label getCapienzaLabel() {
        return capienzaLabel;
    }

    public Label getHotelLabel() {
        return hotelLabel;
    }

    public Label getCostLabel() {
        return costLabel;
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
    public GraphicsController<InfoViaggioListaAlberghiPerCittaElementView> getGraphicsController() {
        return graphicsController;
    }
}
