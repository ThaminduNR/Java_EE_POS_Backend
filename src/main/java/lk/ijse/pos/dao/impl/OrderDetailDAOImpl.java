package lk.ijse.pos.dao.impl;

import lk.ijse.pos.entity.OrderDetail;
import lk.ijse.pos.dao.OrderDetailDAO;
import org.hibernate.Session;

import java.io.Serializable;
import java.util.List;

public class OrderDetailDAOImpl implements OrderDetailDAO {

    @Override
    public OrderDetail save(OrderDetail orderDetail, Session session) throws Exception {
        Serializable save = session.save(orderDetail);
        orderDetail.setId((int)save);
        return orderDetail;
    }

    @Override
    public void delete(OrderDetail entity, Session session) throws Exception {

    }

    @Override
    public void update(OrderDetail entity, Session session) throws Exception {

    }

    @Override
    public OrderDetail findById(Integer integer, Session session) throws Exception {
        return null;
    }

    @Override
    public List<OrderDetail> getAll(Session session) throws Exception {
        return null;
    }
    public void addAll(List<OrderDetail> items, Session session) throws Exception {
        for (OrderDetail ob :items) {
            this.save(ob,session);
        }
    }
}
