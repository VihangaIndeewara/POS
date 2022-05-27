package lk.ijse.pos.bo.Custom.Impl;

import lk.ijse.pos.bo.Custom.PlaceOrderBO;
import lk.ijse.pos.dao.DAOFactory;
import lk.ijse.pos.dto.CustomerDTO;
import lk.ijse.pos.dto.ItemDTO;
import lk.ijse.pos.dto.OrderDTO;
import lk.ijse.pos.dto.OrderDetailDTO;
import lk.ijse.pos.entity.Customer;
import lk.ijse.pos.entity.Item;
import lk.ijse.pos.entity.OrderDetail;
import lk.ijse.pos.entity.Orders;
import lk.ijse.pos.dao.custom.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class PlaceOrderBOImpl implements PlaceOrderBO {

    CustomerDAO customerDAO = (CustomerDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.CUSTOMER);
    ItemDAO itemDAO =(ItemDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.ITEM);
    OrderDAO orderDAO= (OrderDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.ORDER);
    OrderDetailsDAO orderDetailsDAO = (OrderDetailsDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.ORDERDETAILS);
    QuaryDAO quaryDAO = (QuaryDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.QUARY);

    //    CustomerDAO customerDAO=new CustomerDAOImpl();
    //    ItemDAO itemDAO = new ItemDAOImpl();
    //    OrderDAO orderDAO = new OrderDAOImpl();
    //    OrderDetailsDAO orderDetailsDAO = new OrderDetailsDAOImpl();
    //    QuaryDAO quaryDAO = new QuaryDAOImpl();

    public boolean purchaseOrder(OrderDTO dto) throws SQLException, ClassNotFoundException {
        /*Transaction*/
        Connection connection = null;

            boolean exist = orderDAO.exist(dto.getOrderId());


            /*if order id already exist*/
            if (exist) {

            }

            connection.setAutoCommit(false);

            boolean save = orderDAO.save(new Orders(dto.getOrderId(), dto.getOrderDate(), dto.getCustomerId()));

            if (!save) {
                connection.rollback();
                connection.setAutoCommit(true);
                return false;
            }

            for (OrderDetailDTO detailDTO : dto.getOrderDetails()) {
                boolean save1 = orderDetailsDAO.save(new OrderDetail(detailDTO.getoId(),detailDTO.getItemCode(),detailDTO.getQty(),detailDTO.getUnitPrice()));

                if (!save1) {
                    connection.rollback();
                    connection.setAutoCommit(true);
                    return false;
                }

//                //Search & Update Item
                ItemDTO item = searchItem(detailDTO.getItemCode());
                item.setQtyOnHand(item.getQtyOnHand() - detailDTO.getQty());

                boolean update = itemDAO.update(new Item(item.getCode(), item.getDescription(), item.getUnitPrice(), item.getQtyOnHand()));

                if (!update) {
                    connection.rollback();
                    connection.setAutoCommit(true);
                    return false;
                }
            }

            connection.commit();
            connection.setAutoCommit(true);
            return true;

//        return false;
    }

    @Override
    public CustomerDTO searchCustomer(String id) throws SQLException, ClassNotFoundException {
        Customer ent = customerDAO.search(id);
        return  new CustomerDTO(ent.getId(),ent.getName(),ent.getAddress());
    }

    @Override
    public ItemDTO searchItem (String code) throws SQLException, ClassNotFoundException {
        Item ent = itemDAO.search(code);
        return new ItemDTO(ent.getCode(),ent.getDescription(),ent.getUnitPrice(),ent.getQtyOnHand());

    }

    @Override
    public boolean checkItemIsAvailable(String code) throws SQLException, ClassNotFoundException {
        return itemDAO.exist(code);
    }

    @Override
    public boolean checkCustomerIsAvailable(String id) throws SQLException, ClassNotFoundException {
        return customerDAO.exist(id);
    }

    @Override
    public String generateNewOrderId() throws SQLException, ClassNotFoundException {
        return orderDAO.generateNewId();
    }

    @Override
    public ArrayList<CustomerDTO> getAllCustomers() throws SQLException, ClassNotFoundException {
        ArrayList<Customer> all = customerDAO.getAll();
        ArrayList<CustomerDTO> allCustomers=new ArrayList<>();
        for (Customer ent:all) {
            allCustomers.add(new CustomerDTO(ent.getId(),ent.getName(),ent.getAddress()));
        }
        return allCustomers;
    }

    @Override
    public ArrayList<ItemDTO> getAllItems() throws SQLException, ClassNotFoundException {
        ArrayList<Item> all = itemDAO.getAll();
        ArrayList<ItemDTO> allItems=new ArrayList<>();
        for (Item ent :all) {
            allItems.add(new ItemDTO(ent.getCode(),ent.getDescription(),ent.getUnitPrice(),ent.getQtyOnHand()));
        }
        return allItems;
    }
}
