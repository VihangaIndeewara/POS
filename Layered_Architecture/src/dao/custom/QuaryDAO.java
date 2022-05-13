package dao.custom;

import model.CustomDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface QuaryDAO {
    public ArrayList<CustomDTO> searchOrdersByOrderId(String  id) throws SQLException, ClassNotFoundException;
}
