package appcontrollers;

import daos.AggiungiAutobusProcedureDAO;
import daos.EliminaAutobusProcedureDAO;
import daos.ListaAutobusProcedureDAO;
import daos.ListaClientiProcedureDAO;
import dtos.AutobusDTO;
import exception.DAOException;
import exception.InvalidAutobusDataException;
import models.Autobus;
import models.Cliente;

import java.sql.SQLException;
import java.util.List;

public class CustomersController {

    public static List<Cliente> getCustomers() throws DAOException {
        try {
            return new ListaClientiProcedureDAO().execute(null);
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }
}
