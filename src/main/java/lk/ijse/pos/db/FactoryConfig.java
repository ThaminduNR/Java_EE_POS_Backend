package lk.ijse.pos.db;

import lk.ijse.pos.entity.Customer;
import lk.ijse.pos.entity.Item;
import lk.ijse.pos.entity.Order;
import lk.ijse.pos.entity.OrderDetail;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.Session;
public class FactoryConfig {
    private static FactoryConfig instance ;
    private final SessionFactory sessionFactory;
    private FactoryConfig() {
        Configuration configuration = new Configuration().configure().addAnnotatedClass(Item.class).addAnnotatedClass(Customer.class)
                .addAnnotatedClass(Order.class).addAnnotatedClass(OrderDetail.class);
        sessionFactory=configuration.buildSessionFactory();
    }
    public static FactoryConfig getInstance(){
        if (instance == null) instance = new FactoryConfig();
        return instance;
    }
    public Session getSession(){
        return sessionFactory.openSession();
    }
}
