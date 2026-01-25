package graphicscontrollers;

import appcontrollers.LoginController;
import exception.DAOException;
import exception.InvalidCredentialsException;
import views.Icon;
import views.LoginView;
import views.ViewNavigator;

public class LoginViewController extends GraphicsController<LoginView> {

    public LoginViewController(LoginView view) {
        super(view);
        loaded();
    }

    @Override
    public void loaded() {
        getView().getLoginButton().setOnMouseClicked(_ -> loginButtonClicked());
    }

    private void loginButtonClicked() {

        try {
            LoginController.login(getView().getUsernameTextField().getText(), getView().getPasswordTextField().getText());
        } catch (InvalidCredentialsException _) {
            ViewNavigator.displayNotification("Errore", "Credenziali non valide", Icon.APPICON);
        } catch (DAOException e) {
            ViewNavigator.displayNotification("Errore", e.getMessage(), Icon.APPICON);
        }
    }
}
