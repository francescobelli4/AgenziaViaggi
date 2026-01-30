package views;

import graphicscontrollers.DisdiciPrenotazioneViewController;
import graphicscontrollers.GraphicsController;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import utils.Utils;

public class DisdiciPrenotazioneView implements View {

    @FXML
    private StackPane root;
    @FXML
    private TextField codiceTF;
    @FXML
    private Button disdiciButton;

    private static final Page page = Page.DISDICI_PRENOTAZIONE;
    private final GraphicsController<DisdiciPrenotazioneView> graphicsController;

    public DisdiciPrenotazioneView() {
        this.graphicsController = new DisdiciPrenotazioneViewController(this);
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

    public Button getDisdiciButton() {
        return disdiciButton;
    }

    public TextField getCodiceTF() {
        return codiceTF;
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
    public GraphicsController<DisdiciPrenotazioneView> getGraphicsController() {
        return graphicsController;
    }
}
