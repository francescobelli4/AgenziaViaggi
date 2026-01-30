package graphicscontrollers;

import models.Role;
import models.User;
import views.*;

public class HomeViewController extends GraphicsController<HomeView> {

    public HomeViewController(HomeView view) {
        super(view);
        loaded();
    }

    @Override
    public void loaded() {

        getView().getListaItinerariButton().setOnMouseClicked(_ -> listaItinerariButtonClicked());
        getView().getListaViaggiButton().setOnMouseClicked(_ -> listaViaggiButtonClicked());

        if (User.getInstance().getRole() == Role.BOOKING) {
            getView().getLogistics().setManaged(false);
            getView().getLogistics().setVisible(false);
            getView().getListaTappeButton().setManaged(false);
            getView().getListaTappeButton().setVisible(false);

            getView().getListaClientiButton().setOnMouseClicked(_ -> listaClientiButtonClicked());
            getView().getDisdiciPrenotazioneButton().setOnMouseClicked(_ -> disdiciPrenotazioneButton());
        } else {
            getView().getCustomers().setManaged(false);
            getView().getCustomers().setVisible(false);

            getView().getListaTappeButton().setOnMouseClicked(_ -> listaTappeButtonClicked());
            getView().getListaAlberghiButton().setOnMouseClicked(_ -> listaAlberghiButtonClicked());
            getView().getListaAutobusButton().setOnMouseClicked(_ -> listaAutobusButtonClicked());
            getView().getReportsButton().setOnMouseClicked(_ -> reportsButtonClicked());
        }
    }

    private void disdiciPrenotazioneButton() {
        ViewNavigator.displayDisdiciPrenotazioneView();
    }

    private void reportsButtonClicked() {
        ReportsView reportsView = ViewFactory.createReportsView();
        getView().setActiveView(reportsView);
        getView().appendMainElement(reportsView.getRoot());
    }

    private void listaTappeButtonClicked() {
        ListaTappeView listaTappe = ViewFactory.createListaTappeView();
        getView().setActiveView(listaTappe);
        getView().appendMainElement(listaTappe.getRoot());
    }

    private void listaItinerariButtonClicked() {
        ListaItinerariView listaTappe = ViewFactory.createListaItinerariView();
        getView().setActiveView(listaTappe);
        getView().appendMainElement(listaTappe.getRoot());
    }

    private void listaAlberghiButtonClicked() {
        ListaAlberghiView listaAlberghi = ViewFactory.createListaAlberghiView();
        getView().setActiveView(listaAlberghi);
        getView().appendMainElement(listaAlberghi.getRoot());
    }

    private void listaAutobusButtonClicked() {
        ListaAutobusView listaAutobus = ViewFactory.createListaAutobusView();
        getView().setActiveView(listaAutobus);
        getView().appendMainElement(listaAutobus.getRoot());
    }

    private void listaClientiButtonClicked() {
        ListaClientiView listaClienti = ViewFactory.createListaClientiView();
        getView().setActiveView(listaClienti);
        getView().appendMainElement(listaClienti.getRoot());
    }

    private void listaViaggiButtonClicked() {
        ListaViaggiView listaViaggi = ViewFactory.createListaViaggiView();
        getView().setActiveView(listaViaggi);
        getView().appendMainElement(listaViaggi.getRoot());
    }
}
