package lk.ijse.pos.dao.custom;

import lk.ijse.pos.dao.SuperDAO;
import lk.ijse.pos.dto.CustomDTO;
import lk.ijse.pos.entity.CustomEntity;

import java.sql.SQLException;
import java.util.ArrayList;

public interface QuaryDAO extends SuperDAO {
    public ArrayList<CustomEntity> searchOrdersByOrderId(String  id) throws SQLException, ClassNotFoundException;
}
