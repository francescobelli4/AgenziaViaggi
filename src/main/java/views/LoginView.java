package views;

import graphicscontrollers.GraphicsController;
import graphicscontrollers.LoginViewController;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import models.User;
import utils.Utils;

public class LoginView implements View, User.LoginListener {

    @FXML
    private StackPane root;
    @FXML
    private TextField usernameTextField;
    @FXML
    private PasswordField passwordTextField;
    @FXML
    private Button loginButton;

    private static final Page page = Page.LOGIN;
    private final GraphicsController<LoginView> graphicsController;

    public LoginView() {
        this.graphicsController = new LoginViewController(this);
        User.getInstance().addLoginListener(this);
        init();
    }

    @Override
    public void init() {
        Utils.scaleFonts(root);

        usernameTextField.setTextFormatter(Utils.getTextFormatter(16, true));
        passwordTextField.setTextFormatter(Utils.getTextFormatter(32, true));
    }

    @Override
    public void close() {
        //Nothing to do...
    }

    public Button getLoginButton() {
        return loginButton;
    }

    public PasswordField getPasswordTextField() {
        return passwordTextField;
    }

    public TextField getUsernameTextField() {
        return usernameTextField;
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
    public GraphicsController<LoginView> getGraphicsController() {
        return graphicsController;
    }

    @Override
    public void onLoggedIn() {
        ViewNavigator.displayHomeView();
    }
}
