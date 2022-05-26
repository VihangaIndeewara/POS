package dao.custom;

import dao.SuperDAO;
import dto.CustomDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface QuaryDAO extends SuperDAO {
    public ArrayList<CustomDTO> searchOrdersByOrderId(String  id) throws SQLException, ClassNotFoundException;
}
