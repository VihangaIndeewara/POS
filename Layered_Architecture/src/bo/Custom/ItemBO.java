package bo.Custom;

import bo.SuperBO;
import model.ItemDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ItemBO extends SuperBO {
    public ArrayList<ItemDTO> getAllItems() throws SQLException, ClassNotFoundException;

    public boolean deleteItem(String code) throws SQLException, ClassNotFoundException;

    public boolean saveItem(ItemDTO item) throws SQLException, ClassNotFoundException;

    public boolean updateItem(ItemDTO item) throws SQLException, ClassNotFoundException;

    public boolean checkItemIsAvailable(String code) throws SQLException, ClassNotFoundException;

    public String generateNewItemCode() throws SQLException, ClassNotFoundException;
}
