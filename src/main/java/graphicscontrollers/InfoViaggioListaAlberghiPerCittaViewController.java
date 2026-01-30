package graphicscontrollers;

import appcontrollers.HotelController;
import javafx.scene.Node;
import javafx.scene.layout.StackPane;
import models.Albergo;
import models.Tappa;
import views.InfoViaggioListaAlberghiPerCittaElementView;
import views.InfoViaggioListaAlberghiPerCittaView;
import views.ViewFactory;
import views.ViewNavigator;

import java.util.ArrayList;
import java.util.List;

public class InfoViaggioListaAlberghiPerCittaViewController extends GraphicsController<InfoViaggioListaAlberghiPerCittaView> implements InfoViaggioListaAlberghiPerCittaElementViewController.Listener {

    private Listener listener;
    private final Tappa citta;

    public InfoViaggioListaAlberghiPerCittaViewController(InfoViaggioListaAlberghiPerCittaView view, Tappa citta) {
        super(view);
        this.citta = citta;
        loaded();
    }

    @Override
    public void loaded() {

        List<Node> alberghi = new ArrayList<>();

        for (Albergo i : HotelController.getAlberghiPerCitta(citta)) {
            InfoViaggioListaAlberghiPerCittaElementView view = ViewFactory.createInfoViaggioListaAlberghiPerCittaElementView(i);
            ((InfoViaggioListaAlberghiPerCittaElementViewController)view.getGraphicsController()).setListener(this);
            alberghi.add(view.getRoot());
        }

        getView().setHotels(alberghi);
    }

    public void setListener(Listener l) {
        this.listener = l;
    }

    private void rootClicked() {
        ((StackPane)ViewNavigator.getActiveView().getRoot()).getChildren().remove(getView().getRoot());
    }

    @Override
    public void hotelSelected(Albergo albergo) {
        listener.hotelSelected(albergo);
        rootClicked();
    }

    public interface Listener {
        void hotelSelected(Albergo albergo);
    }
}
