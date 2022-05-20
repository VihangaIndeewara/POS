package dao;

import dao.custom.CustomerDAO;
import dao.custom.impl.*;
import org.omg.CORBA.PUBLIC_MEMBER;

public class DAOFactory{
    private static DAOFactory daoFactory;

    private DAOFactory() {
    }

    public static DAOFactory getDaoFactory(){
        if (daoFactory == null){
            daoFactory=new DAOFactory();
        }
        return daoFactory;
    }

    public enum DAOTypes{
        CUSTOMER,ITEM,ORDER,ORDERDETAILS,QUARY;
    }

    public SuperDAO getDAO(DAOTypes types){
        switch (types) {
            case CUSTOMER:
                return new CustomerDAOImpl();
            case ITEM:
                return new ItemDAOImpl();
            case ORDER:
                return new OrderDAOImpl();
            case ORDERDETAILS:
                return new OrderDetailsDAOImpl();
            case QUARY:
                return new QuaryDAOImpl();
            default:
                return null;
        }
    }
}
