package dao;

import model.CustomerDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CrudDAO<T,id> {
    public ArrayList<T> getAll() throws SQLException, ClassNotFoundException;;

    boolean save(T dto) throws SQLException, ClassNotFoundException;

    boolean update(T dto) throws SQLException, ClassNotFoundException;

    boolean exist(id  id) throws SQLException, ClassNotFoundException;;

    boolean delete(id id) throws SQLException, ClassNotFoundException;;

    String  generateNewId() throws SQLException, ClassNotFoundException;;
}
