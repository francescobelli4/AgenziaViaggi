package graphicscontrollers;

import models.Viaggio;
import views.ListaViaggiElementView;
import views.ViewNavigator;

import java.time.format.DateTimeFormatter;

public class ListaViaggiElementViewController extends GraphicsController<ListaViaggiElementView> {

    private final Viaggio viaggio;

    public ListaViaggiElementViewController(ListaViaggiElementView view, Viaggio viaggio) {
        super(view);
        this.viaggio = viaggio;

        loaded();
    }

    @Override
    public void loaded() {

        getView().getCodiceViaggioLabel().setText(viaggio.getCodice());
        getView().getItineraryLabel().setText(viaggio.getItinerario());
        getView().getPartenzaLabel().setText(String.format("Partenza: %s", viaggio.getPartenza().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))));
        getView().getRitornoLabel().setText(String.format("Ritorno: %s", viaggio.getRitorno().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))));

        getView().getRoot().setOnMouseClicked(_ -> elementClicked());
    }

    private void elementClicked() {
        ViewNavigator.displayInfoViaggioView(viaggio);
    }

    public Viaggio getViaggio() {
        return viaggio;
    }
}
