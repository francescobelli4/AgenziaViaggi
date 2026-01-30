package views;

import graphicscontrollers.GraphicsController;
import graphicscontrollers.InfoViaggioPrenotazioneElementViewController;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import models.Cliente;
import utils.Utils;

public class InfoViaggioPrenotazioneElementView implements View {

    @FXML
    private HBox root;
    @FXML
    private Label codPrenotazioneLabel;
    @FXML
    private Label codDisdettaLabel;
    @FXML
    private Label nomeLabel;
    @FXML
    private Label cognomeLabel;
    @FXML
    private Label cfLabel;

    private static final Page page = Page.INFO_VIAGGIO_PRENOTAZIONE_ELEMENT;
    private final GraphicsController<InfoViaggioPrenotazioneElementView> graphicsController;

    public InfoViaggioPrenotazioneElementView(String codicePrenotazione, String codiceDisdetta, Cliente cliente) {
        this.graphicsController = new InfoViaggioPrenotazioneElementViewController(this, codicePrenotazione, codiceDisdetta, cliente);
        init();
    }

    @Override
    public void init() {
        Utils.scaleFonts(root);
    }

    public Label getNomeLabel() {
        return nomeLabel;
    }

    public Label getCognomeLabel() {
        return cognomeLabel;
    }

    public Label getCfLabel() {
        return cfLabel;
    }

    public Label getCodDisdettaLabel() {
        return codDisdettaLabel;
    }

    public Label getCodPrenotazioneLabel() {
        return codPrenotazioneLabel;
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
    public GraphicsController<InfoViaggioPrenotazioneElementView> getGraphicsController() {
        return graphicsController;
    }
}
