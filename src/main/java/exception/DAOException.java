package exception;

import java.sql.SQLException;

public class DAOException extends RuntimeException {

    public DAOException(SQLException e) {
        super(generateMessage(e));
        System.out.println("ERROR CODE: " + e.getErrorCode());
    }

    private static String generateMessage(SQLException e) {
        switch (e.getErrorCode()) {
            // Connessione fallita
            case 2002:
            case 2003:
            case 0:
                return "Errore: Impossibile connettersi alla base di dati.";

            // Accesso negato
            case 1044:
            case 1045:
                return "Errore: Accesso negato.";

            case 1370:
                return "Errore: Accesso ad una procedura negato.";

            case 1062:
                return "Errore: entry già presente nella base dati.";

            case 1451:
                return "Errore: Questo elemento è usato nella definizione di altri elementi.";

            default:
                return "Errore imprevisto del database: " + e.getMessage();
        }
    }
}