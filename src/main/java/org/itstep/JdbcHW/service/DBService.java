package org.itstep.JdbcHW.service;

import org.itstep.JdbcHW.entity.Item;

import java.sql.SQLException;
import java.util.List;

public interface DBService {
    List<Item> getAllItems() throws SQLException;

    Item getItemById(Long id);

    void addItem(String name, Double price);

    void addItem(Item item);

    Item updateItem(Item item);

    void deleteItem(Long id);
}
