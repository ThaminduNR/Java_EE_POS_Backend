package lk.ijse.pos.dao;

import lk.ijse.pos.dao.impl.CustomerRepoImpl;
import lk.ijse.pos.dao.impl.ItemRepoImpl;

public class DaoFactory {

    public enum RepoType {
        ITEM,CUSTOMER,ORDER,ORDER_ITEM
    }
    private static DaoFactory daoFactory;

    public static DaoFactory getInstance(){
      return   daoFactory == null ? daoFactory =new DaoFactory(): daoFactory;
    }
    public <T> T getRepo(RepoType repoType){
        switch (repoType){
            case ITEM:
                return (T) new ItemRepoImpl();
            case CUSTOMER:
                return (T) new CustomerRepoImpl();


        }
        return null;
    }
}
