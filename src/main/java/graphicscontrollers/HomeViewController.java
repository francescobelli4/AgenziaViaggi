package graphicscontrollers;

import views.HomeView;
import views.ListaItinerariView;
import views.ListaTappeView;
import views.ViewFactory;

public class HomeViewController extends GraphicsController<HomeView> {

    public HomeViewController(HomeView view) {
        super(view);
        loaded();
    }

    @Override
    public void loaded() {
        getView().getListaTappeButton().setOnMouseClicked(_ -> listaTappeButtonClicked());
        getView().getListaItinerariButton().setOnMouseClicked(_ -> listaItinerariButtonClicked());
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
}
