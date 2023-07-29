package lk.ijse.pos.dao.impl;

import lk.ijse.pos.entity.Customer;
import lk.ijse.pos.dao.CustomerDAO;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.io.Serializable;
import java.util.List;

public class CustomerRepoImpl implements CustomerDAO {
    @Override
    public Customer save(Customer customer, Session session) {
        Serializable save = session.save(customer);
         customer.setId((int) save);
        return customer;
    }

    @Override
    public void delete(Customer entity, Session session) {
        session.delete(entity);
    }

    @Override
    public void update(Customer entity, Session session) throws Exception{
            session.update(entity);
    }

    @Override
    public Customer findById(Integer id, Session session) {
        String hql = "FROM Customer WHERE id = :id";
        Query<Customer> query = session.createQuery(hql, Customer.class);
        query.setParameter("id", id);
        return query.uniqueResult();
    }

    @Override
    public List<Customer> getAll(Session session) {
        return session.createQuery("FROM Customer ").list();
    }
}
