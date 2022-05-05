package dao;

import model.CustomerDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CustomerDAO {
    public ArrayList<CustomerDTO> getAllCustomers() throws SQLException, ClassNotFoundException;;

    boolean saveCustomer(CustomerDTO customer) throws SQLException, ClassNotFoundException;

    boolean updateCustomer(CustomerDTO dto) throws SQLException, ClassNotFoundException;

    boolean existCustomer(String  id) throws SQLException, ClassNotFoundException;;

    boolean deleteCustomer(String id) throws SQLException, ClassNotFoundException;;

    String  generateCustomerId() throws SQLException, ClassNotFoundException;;
}
