package dao;

import db.DBConnection;
import model.ItemDTO;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;

public interface ItemDAO {
    public ArrayList<ItemDTO> loadAllItem() throws SQLException, ClassNotFoundException ;

    public boolean deleteItem(String code) throws SQLException, ClassNotFoundException ;

    public boolean saveItem(ItemDTO item) throws SQLException, ClassNotFoundException ;

    public boolean updateItem(String description,BigDecimal unitPrice,int qtyOnHand,String code) throws SQLException, ClassNotFoundException ;

    public boolean existsItem(String code) throws SQLException, ClassNotFoundException ;

    public  String genarateItemId() throws SQLException, ClassNotFoundException ;
}
