package graphicscontrollers;

import views.*;

public class HomeViewController extends GraphicsController<HomeView> {

    public HomeViewController(HomeView view) {
        super(view);
        loaded();
    }

    @Override
    public void loaded() {
        getView().getListaTappeButton().setOnMouseClicked(_ -> listaTappeButtonClicked());
        getView().getListaItinerariButton().setOnMouseClicked(_ -> listaItinerariButtonClicked());
        getView().getListaAlberghiButton().setOnMouseClicked(_ -> listaAlberghiButtonClicked());
        getView().getListaAutobusButton().setOnMouseClicked(_ -> listaAutobusButtonClicked());
        getView().getListaClientiButton().setOnMouseClicked(_ -> listaClientiButtonClicked());
        getView().getListaViaggiButton().setOnMouseClicked(_ -> listaViaggiButtonClicked());
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
