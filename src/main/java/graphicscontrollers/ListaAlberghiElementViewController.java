package graphicscontrollers;

import appcontrollers.HotelController;
import exception.DAOException;
import models.Albergo;
import views.*;

public class ListaAlberghiElementViewController extends GraphicsController<ListaAlberghiElementView> {

    private final Albergo albergo;

    public ListaAlberghiElementViewController(ListaAlberghiElementView view, Albergo albergo) {
        super(view);
        this.albergo = albergo;

        loaded();
    }

    @Override
    public void loaded() {
        getView().getHotelLabel().setText(albergo.getNome());
        getView().getCityLabel().setText(albergo.getCitta());
        getView().getDeleteButton().setOnMouseClicked(_ -> deleteButtonClicked());
        getView().getRoot().setOnMouseClicked(_ -> elementClicked());
    }

    private void elementClicked() {
        ViewNavigator.displayAlbergoInfoView(albergo);
    }

    private void deleteButtonClicked() {
        try {
            HotelController.eliminaAlbergo(albergo);

            ListaAlberghiView listaAlberghi = (ListaAlberghiView) ((HomeView)ViewNavigator.getActiveView()).getActiveView();
            ((ListaAlberghiViewController)listaAlberghi.getGraphicsController()).updateLists();
        } catch (DAOException e) {
            ViewNavigator.displayNotification("Errore", e.getMessage(), Icon.APPICON);
        }
    }

    public Albergo getAlbergo() {
        return albergo;
    }
}
