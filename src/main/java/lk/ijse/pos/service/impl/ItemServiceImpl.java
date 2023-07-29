package lk.ijse.pos.service.impl;

import lk.ijse.pos.service.ItemService;
import lk.ijse.pos.db.FactoryConfig;
import lk.ijse.pos.dto.ItemDto;
import lk.ijse.pos.entity.Item;
import lk.ijse.pos.dao.ItemDAO;
import lk.ijse.pos.dao.DaoFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

public class ItemServiceImpl implements ItemService {
    ModelMapper modelMapper = new ModelMapper();
    ItemDAO itemDAO = DaoFactory.getInstance().getRepo(DaoFactory.RepoType.ITEM);

    @Override
    public ItemDto save(ItemDto itemDto) {
        Session session = FactoryConfig.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        try {
            Item item = itemDAO.save(modelMapper.map(itemDto, Item.class), session);

            transaction.commit();
            return modelMapper.map(item, ItemDto.class);
        } catch (Exception e) {
            transaction.rollback();
            return null;
        } finally {
            session.close();
        }
    }

    @Override
    public boolean delete(Integer id) {
        Session session = FactoryConfig.getInstance().getSession();
        ItemDto byId = findById(id);
        Transaction transaction= session.beginTransaction();
        if (byId != null) {
            try {
                itemDAO.delete(modelMapper.map(byId, Item.class), session);
                transaction.commit();
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                transaction.rollback();
            }finally {
                session.close();
            }
        }
        return false;
    }

    @Override
    public boolean update(ItemDto entity) {
        Session session = FactoryConfig.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        try {
            Item map = modelMapper.map(entity, Item.class);
            System.out.println(map);
            map.setItems(null);
            itemDAO.update(map, session);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
            return false;
        } finally {
            session.close();
        }
    }

    @Override
    public ItemDto findById(Integer id) {

        try (Session session = FactoryConfig.getInstance().getSession()) {
            Item item = itemDAO.findById(id, session);
            if (item != null) {
                return modelMapper.map(item, ItemDto.class);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return null;
    }

    @Override
    public List<ItemDto> getAll() {
        List<ItemDto> itemDtos = new ArrayList<>();
        Session session = FactoryConfig.getInstance().getSession();
        try  {
            List<Item> all = itemDAO.getAll(session);
            for (Item item : all) {
                itemDtos.add(modelMapper.map(item, ItemDto.class));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            session.close();
        }
        return itemDtos;
    }
}
