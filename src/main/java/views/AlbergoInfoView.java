package views;

import graphicscontrollers.AlbergoInfoViewController;
import graphicscontrollers.GraphicsController;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.StackPane;
import models.Albergo;
import utils.Utils;

public class AlbergoInfoView implements View {

    @FXML
    private StackPane root;
    @FXML
    private TextArea nomeTA;
    @FXML
    private TextArea cittaTA;
    @FXML
    private TextArea indirizzoTA;
    @FXML
    private TextArea costoTA;
    @FXML
    private TextArea capienzaTA;
    @FXML
    private TextArea referenteTA;
    @FXML
    private TextArea emailTA;
    @FXML
    private TextArea telefonoTA;
    @FXML
    private TextArea faxTA;
    @FXML
    private Label titleLabel;


    private static final Page page = Page.ALBERGO_INFO;
    private final GraphicsController<AlbergoInfoView> graphicsController;

    public AlbergoInfoView(Albergo albergo) {
        this.graphicsController = new AlbergoInfoViewController(this, albergo);
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

    public Label getTitleLabel() {
        return titleLabel;
    }

    public TextArea getCapienzaTA() {
        return capienzaTA;
    }

    public TextArea getCittaTA() {
        return cittaTA;
    }

    public TextArea getCostoTA() {
        return costoTA;
    }

    public TextArea getEmailTA() {
        return emailTA;
    }

    public TextArea getFaxTA() {
        return faxTA;
    }

    public TextArea getIndirizzoTA() {
        return indirizzoTA;
    }

    public TextArea getNomeTA() {
        return nomeTA;
    }

    public TextArea getReferenteTA() {
        return referenteTA;
    }

    public TextArea getTelefonoTA() {
        return telefonoTA;
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
    public GraphicsController<AlbergoInfoView> getGraphicsController() {
        return graphicsController;
    }
}
