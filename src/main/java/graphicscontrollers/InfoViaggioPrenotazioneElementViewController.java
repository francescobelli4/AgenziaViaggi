package graphicscontrollers;

import models.Cliente;
import views.InfoViaggioPrenotazioneElementView;


public class InfoViaggioPrenotazioneElementViewController extends GraphicsController<InfoViaggioPrenotazioneElementView>  {

    private final Cliente cliente;
    private final String codicePrenotazione;
    private final String codiceDisdetta;

    public InfoViaggioPrenotazioneElementViewController(InfoViaggioPrenotazioneElementView view, String codicePrenotazione, String codiceDisdetta, Cliente cliente) {
        super(view);
        this.codicePrenotazione = codicePrenotazione;
        this.codiceDisdetta = codiceDisdetta;
        this.cliente = cliente;
        loaded();
    }


    @Override
    public void loaded() {
        getView().getCodPrenotazioneLabel().setText("Cod Pren: " + codicePrenotazione);
        getView().getCodDisdettaLabel().setText("Cod Disd: " +  codiceDisdetta);
        getView().getNomeLabel().setText(cliente.getNome());
        getView().getCognomeLabel().setText(cliente.getCognome());
        getView().getCfLabel().setText(cliente.getCf());
    }
}
