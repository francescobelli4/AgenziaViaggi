package views;

import graphicscontrollers.GraphicsController;
import graphicscontrollers.HomeViewController;
import graphicscontrollers.LoginViewController;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import utils.Utils;

public class HomeView implements View {

    @FXML
    private StackPane root;

    private static final Page page = Page.HOME;
    private final GraphicsController<HomeView> graphicsController;

    public HomeView() {
        this.graphicsController = new HomeViewController(this);
        init();
    }

    @Override
    public void init() {
        //Utils.scaleFonts(root);
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
    public GraphicsController<HomeView> getGraphicsController() {
        return graphicsController;
    }
}
