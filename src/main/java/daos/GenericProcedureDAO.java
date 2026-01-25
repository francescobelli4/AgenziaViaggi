package daos;

import exception.DAOException;

import java.sql.SQLException;

/**
 * This interface should only represent a contract in the interaction with the dbms' procedures.
 * @param <I> an input DTO
 * @param <O> the procedure's output value
 */
public interface GenericProcedureDAO<I, O> {
    O execute(I input) throws DAOException, SQLException;
}
