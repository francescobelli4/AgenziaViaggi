package views;

import graphicscontrollers.AggiungiPrenotazioneElementViewController;
import graphicscontrollers.GraphicsController;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import utils.Utils;

public class AggiungiPrenotazioneElementView implements View {

    @FXML
    private HBox root;
    @FXML
    private TextField cfTF;
    @FXML
    private TextField nomeTF;
    @FXML
    private TextField cognomeTF;

    private static final Page page = Page.AGGIUNGI_PRENOTAZIONE_ELEMENT;
    private final GraphicsController<AggiungiPrenotazioneElementView> graphicsController;

    public AggiungiPrenotazioneElementView() {
        this.graphicsController = new AggiungiPrenotazioneElementViewController(this);
        init();
    }

    @Override
    public void init() {
        Utils.scaleFonts(root);

        getCfTF().setTextFormatter(Utils.getTextFormatter(17, true));
        getNomeTF().setTextFormatter(Utils.getTextFormatter(64, true));
        getCognomeTF().setTextFormatter(Utils.getTextFormatter(64, true));
    }

    public TextField getNomeTF() {
        return nomeTF;
    }

    public TextField getCognomeTF() {
        return cognomeTF;
    }

    public TextField getCfTF() {
        return cfTF;
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
    public GraphicsController<AggiungiPrenotazioneElementView> getGraphicsController() {
        return graphicsController;
    }
}
