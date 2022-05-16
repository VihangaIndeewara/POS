package bo;

import dao.custom.ItemDAO;
import dao.custom.impl.ItemDAOImpl;
import model.ItemDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class ItemBOImpl {
    //Property Injection(DI)
    private final ItemDAO itemDAO = new ItemDAOImpl();

    public ArrayList<ItemDTO> getAllItems() throws SQLException, ClassNotFoundException {
        return itemDAO.getAll();
    }

    public boolean deleteItem(String code) throws SQLException, ClassNotFoundException {
        return itemDAO.delete(code);
    }

    public boolean saveItem(ItemDTO item) throws SQLException, ClassNotFoundException {
        return itemDAO.save(item);
    }

    public boolean updateItem(ItemDTO item) throws SQLException, ClassNotFoundException {
        return itemDAO.update(item);
    }

    public boolean checkItemIsAvailable(String code) throws SQLException, ClassNotFoundException {
        return itemDAO.exist(code);
    }

    public String generateNewItemCode() throws SQLException, ClassNotFoundException {
        return itemDAO.generateNewId();
    }
}
