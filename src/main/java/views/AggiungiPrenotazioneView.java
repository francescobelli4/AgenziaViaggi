package views;

import graphicscontrollers.AggiungiPrenotazioneViewController;
import graphicscontrollers.GraphicsController;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import models.Viaggio;
import utils.Utils;

public class AggiungiPrenotazioneView implements View {

    @FXML
    private StackPane root;
    @FXML
    private Button aggiungiButton;
    @FXML
    private VBox listaPrenotati;
    @FXML
    private Button confermaButton;

    private static final Page page = Page.AGGIUNGI_PRENOTAZIONE;
    private final GraphicsController<AggiungiPrenotazioneView> graphicsController;

    public AggiungiPrenotazioneView(Viaggio viaggio) {
        this.graphicsController = new AggiungiPrenotazioneViewController(this, viaggio);
        init();
    }

    @Override
    public void init() {
        Utils.scaleFonts(root);
    }

    @Override
    public void close() {
        //Nothing to do...
    }

    public Button getAggiungiButton() {
        return aggiungiButton;
    }

    public Button getConfermaButton() {
        return confermaButton;
    }

    public VBox getListaPrenotati() {
        return listaPrenotati;
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
    public GraphicsController<AggiungiPrenotazioneView> getGraphicsController() {
        return graphicsController;
    }
}
