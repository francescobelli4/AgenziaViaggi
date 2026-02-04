package graphicscontrollers;

import appcontrollers.CustomersController;
import com.google.gson.Gson;
import dtos.ClienteDTO;
import dtos.PrenotazioneDTO;
import exception.DAOException;
import javafx.scene.layout.StackPane;
import models.Viaggio;
import views.*;

import java.util.ArrayList;
import java.util.List;

public class AggiungiPrenotazioneViewController extends GraphicsController<AggiungiPrenotazioneView> {

    private final Viaggio viaggio;
    private final List<AggiungiPrenotazioneElementView> prenotati = new ArrayList<>();

    private Listener listener;

    public AggiungiPrenotazioneViewController(AggiungiPrenotazioneView view, Viaggio viaggio) {
        super(view);
        this.viaggio = viaggio;
        loaded();
    }

    public void setListener(Listener l) {
        listener = l;
    }

    @Override
    public void loaded() {
        getView().getRoot().setOnMouseClicked(_ -> rootClicked());
        getView().getAggiungiButton().setOnMouseClicked(_ -> aggiungiButtonClicked());
        getView().getConfermaButton().setOnMouseClicked(_ -> confermaButtonClicked());
    }

    private void rootClicked() {
        ViewNavigator.closeCurrentFloatingPage();
    }


    private void aggiungiButtonClicked() {
        AggiungiPrenotazioneElementView view = ViewFactory.createAggiungiPrenotazioneElementView();
        prenotati.add(view);
        getView().getListaPrenotati().getChildren().add(view.getRoot());
    }

    private void confermaButtonClicked() {

        if (prenotati.isEmpty()) {
            ViewNavigator.displayNotification("Errore", "Deve esserci almeno un cliente per la prenotazione.", Icon.APPICON);
            return;
        }

        List<ClienteDTO> clienti = new ArrayList<>();
        for (AggiungiPrenotazioneElementView clView : prenotati) {

            if (clView.getCfTF().getText().isBlank() || clView.getNomeTF().getText().isBlank() || clView.getCognomeTF().getText().isBlank()) {
                ViewNavigator.displayNotification("Errore", "Uno dei prenotati ha dati non validi.", Icon.APPICON);
                return;
            }

            ClienteDTO cl = new ClienteDTO(clView.getCfTF().getText(), clView.getNomeTF().getText(), clView.getCognomeTF().getText());
            clienti.add(cl);
        }

        try {
            CustomersController.aggiungiPrenotazione(new PrenotazioneDTO(viaggio.getCodice(), new Gson().toJson(clienti)));
            listener.prenotazioneAggiunta();
            rootClicked();
        } catch (DAOException e) {
            ViewNavigator.displayNotification("Errore", e.getMessage(), Icon.APPICON);
        }
    }

    public interface Listener {
        void prenotazioneAggiunta();
    }
}
