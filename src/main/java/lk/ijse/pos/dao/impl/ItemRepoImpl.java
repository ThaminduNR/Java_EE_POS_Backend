package lk.ijse.pos.dao.impl;

import lk.ijse.pos.entity.Item;
import lk.ijse.pos.dao.ItemDAO;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.io.Serializable;
import java.util.List;

public class ItemRepoImpl implements ItemDAO {
    @Override
    public Item save(Item entity, Session session)  throws Exception {
        System.out.println(entity);
        entity.setItems(null);
        Serializable save = session.save(entity);
        entity.setId((int) save);
        return entity;
    }

    @Override
    public void delete(Item entity, Session session) throws Exception {
                    session.delete(entity);
    }

    @Override
    public void update(Item entity, Session session) throws Exception {
                    session.update(entity);
    }

    @Override
    public Item findById(Integer id, Session session) throws Exception {
        String hql = "FROM Item WHERE id = :id";
        Query<Item> query = session.createQuery(hql, Item.class);
        query.setParameter("id", id);
        return query.uniqueResult();
    }

    @Override
    public List<Item> getAll(Session session) {
        return session.createQuery("FROM Item").list();
    }
}
