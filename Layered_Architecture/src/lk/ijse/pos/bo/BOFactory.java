package lk.ijse.pos.bo;

import lk.ijse.pos.bo.Custom.Impl.CustomerBOImpl;
import lk.ijse.pos.bo.Custom.Impl.ItemBOImpl;
import lk.ijse.pos.bo.Custom.Impl.PlaceOrderBOImpl;

public class BOFactory {
    private static BOFactory boFactory;

    private BOFactory(){
    }

    public static BOFactory getBoFactory(){
        if (boFactory==null) {
            boFactory=new BOFactory();
        }
        return boFactory;
    }

    public enum BOTypes{
        CUSTOMER,ITEM,PLACEORDER
    }

    public SuperBO getBO(BOTypes types){
        switch (types){
            case CUSTOMER:
                return new CustomerBOImpl();
            case ITEM:
                return new ItemBOImpl();
            case PLACEORDER:
                return new PlaceOrderBOImpl();
            default:
                return null;
        }
    }
}
