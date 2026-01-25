package views;

import graphicscontrollers.GraphicsController;
import graphicscontrollers.HomeViewController;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import models.User;
import utils.Utils;

public class HomeView implements View {

    @FXML
    private StackPane root;
    @FXML
    private VBox mainContainer;
    @FXML
    private Label welcomeLabel;
    @FXML
    private Button listaViaggiButton;
    @FXML
    private Button listaItinerariButton;
    @FXML
    private Button listaTappeButton;
    @FXML
    private Button listaAlberghiButton;
    @FXML
    private Button listaAutobusButton;
    @FXML
    private Button listaClientiButton;

    private View activeView;


    private static final Page page = Page.HOME;
    private final GraphicsController<HomeView> graphicsController;

    public HomeView() {
        this.graphicsController = new HomeViewController(this);
        init();
    }

    @Override
    public void init() {
        Utils.scaleFonts(root);

        welcomeLabel.setText(String.format("Benvenuto, %s.", User.getInstance().getUsername()));
    }

    @Override
    public void close() {
        //Nothing to do...
    }

    public void appendMainElement(Node root) {
        mainContainer.getChildren().clear();
        mainContainer.getChildren().add(root);
    }

    public View getActiveView() {
        return activeView;
    }

    public void setActiveView(View activeView) {
        this.activeView = activeView;
    }

    public Button getListaAlberghiButton() {
        return listaAlberghiButton;
    }

    public Button getListaAutobusButton() {
        return listaAutobusButton;
    }

    public Button getListaClientiButton() {
        return listaClientiButton;
    }

    public Button getListaItinerariButton() {
        return listaItinerariButton;
    }

    public Button getListaTappeButton() {
        return listaTappeButton;
    }

    public Button getListaViaggiButton() {
        return listaViaggiButton;
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
    public GraphicsController<HomeView> getGraphicsController() {
        return graphicsController;
    }
}
