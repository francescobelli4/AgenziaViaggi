package graphicscontrollers;

import models.Albergo;
import views.InfoViaggioListaAlberghiPerCittaElementView;

public class InfoViaggioListaAlberghiPerCittaElementViewController extends GraphicsController<InfoViaggioListaAlberghiPerCittaElementView> {

    private Listener listener;
    private final Albergo albergo;

    public InfoViaggioListaAlberghiPerCittaElementViewController(InfoViaggioListaAlberghiPerCittaElementView view, Albergo albergo) {
        super(view);
        this.albergo = albergo;
        loaded();
    }

    @Override
    public void loaded() {
        getView().getRoot().setOnMouseClicked(_ -> rootClicked());

        getView().getHotelLabel().setText(albergo.getNome());
        getView().getCostLabel().setText(albergo.getCosto() + " €/persona");
        getView().getCapienzaLabel().setText(albergo.getCapienza()+" Persone");
    }

    public void setListener(Listener listener) {
        this.listener = listener;
    }

    private void rootClicked() {
        listener.hotelSelected(albergo);
    }

    public Albergo getAlbergo() {
        return albergo;
    }

    public interface Listener {
        void hotelSelected(Albergo albergo);
    }
}
