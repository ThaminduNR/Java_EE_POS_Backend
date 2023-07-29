package lk.ijse.pos.service.impl;

import lk.ijse.pos.service.OrderService;
import lk.ijse.pos.dto.OrderDetailDto;
import lk.ijse.pos.entity.Order;
import lk.ijse.pos.dao.CustomerDAO;
import lk.ijse.pos.dao.ItemDAO;
import lk.ijse.pos.dao.OrderDAO;
import lk.ijse.pos.dao.DaoFactory;
import org.modelmapper.ModelMapper;

import java.util.List;

public class OrderServiceImpl implements OrderService {
    private OrderDAO orderDAO = DaoFactory.getInstance().getRepo(DaoFactory.RepoType.ORDER);
    private ItemDAO itemDAO = DaoFactory.getInstance().getRepo(DaoFactory.RepoType.ITEM);
    private CustomerDAO customerRepo= DaoFactory.getInstance().getRepo(DaoFactory.RepoType.CUSTOMER);
    ModelMapper modelMapper=new ModelMapper();
    @Override
    public OrderDetailDto save(OrderDetailDto orderDetailDto) {
        Order map = modelMapper.map(orderDetailDto, Order.class);
        return null;
    }

    @Override
    public boolean delete(Integer integer) {
        return false;
    }

    @Override
    public boolean update(OrderDetailDto entity) {
        return false;
    }

    @Override
    public OrderDetailDto findById(Integer integer) {
        return null;
    }

    @Override
    public List<OrderDetailDto> getAll() {
        return null;
    }
}
