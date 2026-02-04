package graphicscontrollers;

import appcontrollers.AutobusController;
import appcontrollers.ItinerariesController;
import appcontrollers.ToursController;
import exception.DAOException;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import models.*;
import views.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class InfoViaggioViewController extends GraphicsController<InfoViaggioView> implements AggiungiPrenotazioneViewController.Listener {

    private final Viaggio viaggio;
    private final List<InfoViaggioTappaElementView> tappeViews = new ArrayList<>();
    private final List<InfoViaggioAutobusElementView> autobusViews = new ArrayList<>();

    public InfoViaggioViewController(InfoViaggioView view, Viaggio viaggio) {
        super(view);
        this.viaggio = viaggio;
        loaded();
    }

    @Override
    public void loaded() {

        Role userRole = User.getInstance().getRole();
        long giorniAllaPartenza = ChronoUnit.DAYS.between(LocalDate.now(), viaggio.getPartenza());
        boolean prenotazioniAperte = giorniAllaPartenza > 20;
        boolean viaggioPassato = giorniAllaPartenza < 0;
        boolean periodoLogistica = !prenotazioniAperte && !viaggioPassato;
        boolean showAggiungiPrenotatiButton = userRole == Role.BOOKING && prenotazioniAperte;
        boolean showLogistica = userRole == Role.AMMINISTRAZIONE && periodoLogistica;

        getView().getRoot().setOnMouseClicked(_ -> rootClicked());
        getView().getCodiceViaggioLabel().setText(viaggio.getCodice());
        getView().getNomeItinerarioLabel().setText(viaggio.getItinerario());
        getView().getDataPartenzaLabel().setText(viaggio.getPartenza().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        getView().getDataRitornoLabel().setText(viaggio.getRitorno().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));

        if (showLogistica) {
            mostraTappe();
            mostraAutobus();
            getView().getConfermaButton().setOnMouseClicked(_ -> confermaButtonClicked());
        } else {
            showElement(getView().getLogisticsContainer(), false);
            showElement(getView().getConfermaButton(), false);
        }

        if (showAggiungiPrenotatiButton) {
            getView().getAggiungiPrenotatiButton().setOnMouseClicked(this::aggiungiPrenotatiButtonClicked);
        } else {
            showElement(getView().getAggiungiPrenotatiButton(), false);
        }

        mostraPrenotati();
    }

    private void showElement(Node node, boolean hide) {
        node.setManaged(hide);
        node.setVisible(hide);
    }

    private void mostraTappe() {
        List<Node> tappe = new ArrayList<>();
        List<Pernottamento> scelti = ToursController.getPernottamentiPerViaggio(viaggio);
        for (Tappa t : ItinerariesController.getTappePerItinerario(viaggio.getItinerario())) {
            InfoViaggioTappaElementView tv = ViewFactory.createInfoViaggioTappaElementView(t);
            tappeViews.add(tv);
            tappe.add(tv.getRoot());
        }

        for (Pernottamento p : scelti) {
            ((InfoViaggioTappaElementViewController)tappeViews.get(p.getOrdine()).getGraphicsController()).hotelSelected(p.getAlbergo());
        }

        getView().setTappe(tappe);
    }

    private void mostraAutobus() {
        List<Node> autobus = new ArrayList<>();
        List<String> scelti = ToursController.getAutobusPerViaggio(viaggio);

        for (Autobus t : AutobusController.getAutobus()) {
            InfoViaggioAutobusElementView av = ViewFactory.createInfoViaggioAutobusElementView(t);
            autobusViews.add(av);

            if (scelti.contains(t.getTarga())) {
                av.getCheckBox().setSelected(true);
                autobus.addFirst(av.getRoot());
            } else {
                autobus.add(av.getRoot());
            }
        }
        getView().setAutobus(autobus);
    }

    private void mostraPrenotati() {
        List<Node> prenotati = new ArrayList<>();
        for (Prenotazione t : ToursController.getPrenotazioniPerViaggio(viaggio)) {

            for (Map.Entry<String, Cliente> c : t.getClienti().entrySet()) {
                prenotati.add(ViewFactory.createInfoViaggioPrenotazioneElementView(t.getCodicePrenotazione(), c.getKey(), c.getValue()).getRoot());
            }
        }
        getView().setPrenotati(prenotati);
    }

    private void aggiungiPrenotatiButtonClicked(MouseEvent e) {
        e.consume();
        AggiungiPrenotazioneView view = ViewNavigator.displayAggiungiPrenotazioneView(viaggio);
        ((AggiungiPrenotazioneViewController) view.getGraphicsController()).setListener(this);
    }

    private void rootClicked() {
        ViewNavigator.closeCurrentFloatingPage();
    }

    private void confermaButtonClicked() {

        List<Pernottamento> pernottamenti = new ArrayList<>();
        List<Autobus> autobus = new ArrayList<>();

        int i = 0;
        for (InfoViaggioTappaElementView tappa : tappeViews) {
            InfoViaggioTappaElementViewController controller = (InfoViaggioTappaElementViewController) tappa.getGraphicsController();

            if (controller.getSelectedHotel() != null) {
                pernottamenti.add(new Pernottamento(controller.getSelectedHotel(), i));
            }

            i++;
        }

        for (InfoViaggioAutobusElementView a : autobusViews) {
            InfoViaggioAutobusElementViewController controller = (InfoViaggioAutobusElementViewController) a.getGraphicsController();

            if (a.getCheckBox().isSelected()) {
                autobus.add(controller.getAutobus());
            }
        }

        try {
            ToursController.scegliLogisticaViaggio(viaggio, pernottamenti, autobus);
            rootClicked();
        } catch (DAOException e) {
            ViewNavigator.displayNotification("Errore", e.getMessage(), Icon.APPICON);
        }
    }

    public Viaggio getViaggio() {
        return viaggio;
    }

    @Override
    public void prenotazioneAggiunta() {
        mostraPrenotati();
    }
}
