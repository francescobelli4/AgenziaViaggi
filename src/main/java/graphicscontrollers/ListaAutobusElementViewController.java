package graphicscontrollers;

import appcontrollers.AutobusController;
import exception.DAOException;
import models.Autobus;
import views.*;

import java.util.function.Consumer;

public class ListaAutobusElementViewController extends GraphicsController<ListaAutobusElementView> {

    Consumer<Autobus> onDeleted;
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

    public void setOnDeleted(Consumer<Autobus> onDeleted) {
        this.onDeleted = onDeleted;
    }

    private void deleteButtonClicked() {
        try {
            AutobusController.eliminaAutobus(autobus);
            if (onDeleted != null) onDeleted.accept(autobus);
        } catch (DAOException e) {
            ViewNavigator.displayNotification("Errore", e.getMessage(), Icon.APPICON);
        }
    }

    public Autobus getAutobus() {
        return autobus;
    }
}
