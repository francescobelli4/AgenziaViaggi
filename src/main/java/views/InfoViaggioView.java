package views;

import graphicscontrollers.GraphicsController;
import graphicscontrollers.InfoViaggioViewController;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import models.Viaggio;
import utils.Utils;

import java.util.List;

public class InfoViaggioView implements View {

    @FXML
    private StackPane root;
    @FXML
    private Label codiceViaggioLabel;
    @FXML
    private Label nomeItinerarioLabel;
    @FXML
    private Label dataPartenzaLabel;
    @FXML
    private Label dataRitornoLabel;
    @FXML
    private HBox logisticsContainer;
    @FXML
    private Label prenotatiLabel;
    @FXML
    private VBox listaPrenotatiContainer;
    @FXML
    private VBox tappeContainer;
    @FXML
    private VBox listaAutobusContainer;
    @FXML
    private Button aggiungiPrenotatiButton;
    @FXML
    private Button confermaButton;

    private static final Page page = Page.INFO_VIAGGIO;
    private final GraphicsController<InfoViaggioView> graphicsController;

    public InfoViaggioView(Viaggio viaggio) {
        this.graphicsController = new InfoViaggioViewController(this, viaggio);
        init();
    }

    @Override
    public void init() {
        Utils.scaleFonts(root);
    }

    public void setTappe(List<Node> tappe) {
        tappeContainer.getChildren().clear();
        tappeContainer.getChildren().addAll(tappe);
    }

    public void setAutobus(List<Node> autobus) {
        listaAutobusContainer.getChildren().clear();
        listaAutobusContainer.getChildren().addAll(autobus);
    }

    public void setPrenotati(List<Node> prenotati) {
        prenotatiLabel.setText(prenotati.size() + " Prenotati");

        listaPrenotatiContainer.getChildren().clear();
        listaPrenotatiContainer.getChildren().addAll(prenotati);
    }

    public Label getCodiceViaggioLabel() {
        return codiceViaggioLabel;
    }

    public Button getAggiungiPrenotatiButton() {
        return aggiungiPrenotatiButton;
    }

    public Button getConfermaButton() {
        return confermaButton;
    }

    public HBox getLogisticsContainer() {
        return logisticsContainer;
    }

    public Label getDataPartenzaLabel() {
        return dataPartenzaLabel;
    }

    public Label getDataRitornoLabel() {
        return dataRitornoLabel;
    }

    public Label getNomeItinerarioLabel() {
        return nomeItinerarioLabel;
    }

    public Label getPrenotatiLabel() {
        return prenotatiLabel;
    }

    public VBox getListaPrenotatiContainer() {
        return listaPrenotatiContainer;
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
    public GraphicsController<InfoViaggioView> getGraphicsController() {
        return graphicsController;
    }
}
