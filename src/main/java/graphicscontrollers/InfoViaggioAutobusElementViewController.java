package graphicscontrollers;

import models.Autobus;
import views.InfoViaggioAutobusElementView;


public class InfoViaggioAutobusElementViewController extends GraphicsController<InfoViaggioAutobusElementView>  {

    private Autobus autobus;

    public InfoViaggioAutobusElementViewController(InfoViaggioAutobusElementView view, Autobus autobus) {
        super(view);
        this.autobus = autobus;
        loaded();
    }


    @Override
    public void loaded() {
        getView().getTargaLabel().setText(autobus.getTarga());
        getView().getCostoLabel().setText(autobus.getCosto() + " €/gg");
        getView().getCapienzaLabel().setText(autobus.getCapienza() + " posti");
    }

    public Autobus getAutobus() {
        return autobus;
    }
}
