package graphicscontrollers;

import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import models.Itinerario;
import views.AggiungiViaggioItinerarioElementView;


public class AggiungiViaggioItinerarioElementViewController extends GraphicsController<AggiungiViaggioItinerarioElementView> {

    private Itinerario itinerario;
    private Listener listener;

    public AggiungiViaggioItinerarioElementViewController(AggiungiViaggioItinerarioElementView view, Itinerario itinerario) {
        super(view);
        this.itinerario = itinerario;
        loaded();
    }

    public void setListener(Listener l) {
        listener = l;
    }

    @Override
    public void loaded() {
        getView().getRoot().setOnMouseClicked(this::onClicked);

        getView().getItineraryLabel().setText(itinerario.getNome());
    }

    private void onClicked(MouseEvent e) {
        e.consume();
        listener.selected(itinerario, getView().getRoot());
    }

    public interface Listener {
        void selected(Itinerario itinerario, Node node);
    }
}
