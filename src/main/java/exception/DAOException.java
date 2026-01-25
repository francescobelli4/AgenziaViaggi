package exception;

import java.sql.SQLException;

public class DAOException extends RuntimeException {
    public DAOException(SQLException e) {

        String message;
        switch (e.getErrorCode()) {
            // Connessione fallita
            case 2002:
            case 2003:
            case 0:
                message = "Errore: Impossibile connettersi alla base di dati.";

            // Accesso negato
            case 1044:
            case 1045:
                message = "Errore: Accesso negato.";

            default:
                message = "Errore imprevisto del database: " + e.getMessage();
        }

        super(message);
    }
}
