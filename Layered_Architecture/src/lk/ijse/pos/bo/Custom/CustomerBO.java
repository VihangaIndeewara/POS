package lk.ijse.pos.bo.Custom;

import lk.ijse.pos.bo.SuperBO;
import lk.ijse.pos.dto.CustomerDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CustomerBO extends SuperBO {
    public ArrayList<CustomerDTO> getAllCustomers() throws SQLException, ClassNotFoundException;

    public boolean saveCustomer(CustomerDTO customer) throws SQLException, ClassNotFoundException;

    public boolean updateCustomer(CustomerDTO customer) throws SQLException, ClassNotFoundException;

    public boolean checkCustomerIsAvailable(String id) throws SQLException, ClassNotFoundException;

    public boolean deleteCustomer(String id) throws SQLException, ClassNotFoundException;

    public String generateNewCustomerId() throws SQLException, ClassNotFoundException;
}