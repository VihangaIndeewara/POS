package dao;

import model.CustomerDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CrudDAO<T,Id> extends SuperDAO {
    public ArrayList<T> getAll() throws SQLException, ClassNotFoundException;

    boolean save(T dto) throws SQLException, ClassNotFoundException;

    boolean update(T dto) throws SQLException, ClassNotFoundException;

    boolean exist(Id  id) throws SQLException, ClassNotFoundException;

    T search(Id id)throws  SQLException,ClassNotFoundException;

    boolean delete(Id id) throws SQLException, ClassNotFoundException;

    String  generateNewId() throws SQLException, ClassNotFoundException;


}
