package graphicscontrollers;

import appcontrollers.LoginController;
import exception.DAOException;
import exception.InvalidCredentialsException;
import views.HomeView;
import views.Icon;
import views.LoginView;
import views.ViewNavigator;

public class HomeViewController extends GraphicsController<HomeView> {

    public HomeViewController(HomeView view) {
        super(view);
    }

    @Override
    public void loaded() {

    }
}
