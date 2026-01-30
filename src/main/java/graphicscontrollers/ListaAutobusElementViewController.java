package graphicscontrollers;

import appcontrollers.AutobusController;
import exception.DAOException;
import models.Autobus;
import views.*;

public class ListaAutobusElementViewController extends GraphicsController<ListaAutobusElementView> {

    private final Autobus autobus;

    public ListaAutobusElementViewController(ListaAutobusElementView view, Autobus autobus) {
        super(view);
        this.autobus = autobus;

        loaded();
    }

    @Override
    public void loaded() {
        getView().getTargaLabel().setText(autobus.getTarga());
        getView().getCostoLabel().setText(String.format("%d €/gg", autobus.getCosto()));
        getView().getCapienzaLabel().setText(String.format("%d posti", autobus.getCapienza()));
        getView().getDeleteButton().setOnMouseClicked(_ -> deleteButtonClicked());
    }

    private void deleteButtonClicked() {
        try {
            AutobusController.eliminaAutobus(autobus);

            ListaAutobusView listaAutobus = (ListaAutobusView) ((HomeView)ViewNavigator.getActiveView()).getActiveView();
            ((ListaAutobusViewController)listaAutobus.getGraphicsController()).updateLists();
        } catch (DAOException e) {
            ViewNavigator.displayNotification("Errore", e.getMessage(), Icon.APPICON);
        }
    }

    public Autobus getAutobus() {
        return autobus;
    }
}
