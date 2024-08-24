package lk.ijse.thogakade_pos_backend.dao;

import lk.ijse.thogakade_pos_backend.dao.custom.impl.CustomerDAOImpl;
import lk.ijse.thogakade_pos_backend.dao.custom.impl.ItemDAOImpl;

public class DAOFactory {

    private static DAOFactory daoFactory;

    private DAOFactory(){
    }

    public static DAOFactory getDaoFactory(){
        return (daoFactory == null) ? new DAOFactory() : daoFactory;
    }

    public enum DAOTypes{
        CUSTOMER,ITEM
    }

    public CrudDAO getDAO(DAOTypes daoTypes){

        switch (daoTypes){
            case CUSTOMER:
                return new CustomerDAOImpl();
            case ITEM:
                return new ItemDAOImpl();
            default:
                return null;
        }
    }
}
