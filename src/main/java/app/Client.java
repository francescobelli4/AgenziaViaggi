package app;

import utils.Utils;

import java.sql.SQLException;
import java.sql.SQLInvalidAuthorizationSpecException;
import java.sql.SQLNonTransientConnectionException;

public class Client {

    static void main() {

        String[] args = new String[]{};

        try {
            AppContext.performConnection(Utils.getProperty("LOGIN_USER"), Utils.getProperty("LOGIN_PASS"));
        } catch (SQLInvalidAuthorizationSpecException _) {
            args = new String[]{"wrong_credentials", "Credenziali di accesso errate"};
        } catch (SQLNonTransientConnectionException _) {
            args = new String[]{"connection_failed", "Connessione con la base dati fallita"};
        } catch (SQLException e) {
            args = new String[]{"generic_sql_exception", e.getMessage()};
        } catch (IllegalStateException e) {
            args = new String[]{"properties_file_error", e.getMessage()};
        } finally {
            Launcher.initialize(args);
        }
    }
}
