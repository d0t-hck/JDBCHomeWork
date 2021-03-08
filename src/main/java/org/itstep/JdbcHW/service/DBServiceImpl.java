package org.itstep.JdbcHW.service;

import org.itstep.JdbcHW.config.DBManager;
import org.itstep.JdbcHW.entity.Item;

import java.sql.SQLException;
import java.util.List;

public class DBServiceImpl implements DBService {

    private DBManager dbManager = new DBManager();

    @Override
    public List<Item> getAllItems() throws SQLException {
        return dbManager.getAllItems();
    }

    @Override
    public Item getItemById(Long id) {
        return dbManager.getItem(id);
    }

    @Override
    public void addItem(String name, Double price) {
        dbManager.addItem(name, price);
    }

    @Override
    public void addItem(Item item) {
        dbManager.addItem(item);
    }

    @Override
    public Item updateItem(Item item) {
        dbManager.updateItem(item);
        return dbManager.getItem(item.getId());
    }

    @Override
    public void deleteItem(Long id) {
        dbManager.deleteItem(id);
    }
}
