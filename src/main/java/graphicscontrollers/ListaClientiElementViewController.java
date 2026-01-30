package graphicscontrollers;

import models.Cliente;
import views.ListaClientiElementView;

public class ListaClientiElementViewController extends GraphicsController<ListaClientiElementView> {

    private final Cliente cliente;

    public ListaClientiElementViewController(ListaClientiElementView view, Cliente cliente) {
        super(view);
        this.cliente = cliente;

        loaded();
    }

    @Override
    public void loaded() {
        getView().getCfLabel().setText(cliente.getCf());
        getView().getNomeLabel().setText(cliente.getNome());
        getView().getCognomeLabel().setText(cliente.getCognome());
    }



    public Cliente getCliente() {
        return cliente;
    }
}
