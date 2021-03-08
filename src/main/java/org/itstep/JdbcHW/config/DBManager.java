package org.itstep.JdbcHW.config;

import org.itstep.JdbcHW.entity.Item;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBManager {

    private static final String QUERY_ALL = "SELECT * FROM items";
    private static final String QUERY_ID = "SELECT * FROM items WHERE id = ?";
    private static final String CREATE_QUERY = "INSERT INTO items (name, price) VALUES (?, ?)";
    private static final String UPDATE_QUERY = "UPDATE items SET name = ?, price = ? WHERE id = ?";
    private static final String DELETE_QUERY = "DELETE FROM items WHERE id = ?";

    public List<Item> getAllItems() throws SQLException {
        List<Item> itemList = new ArrayList<>();
        try {
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "9537");
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Item item = new Item();
                item.setId(resultSet.getLong("id"));
                item.setName(resultSet.getString("name"));
                item.setPrice(resultSet.getDouble("price"));
                itemList.add(item);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return itemList;
    }

    public Item getItem(Long id) {
        Item item = new Item();
        try {
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "9537");
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY_ID);
            preparedStatement.setLong(1, id);
            ResultSet result = preparedStatement.executeQuery();
            while (result.next()) {
                item.setId(result.getLong("id"));
                item.setName(result.getString("name"));
                item.setPrice(result.getDouble("price"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return item;
    }

    public void addItem(String name, Double price) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "9537");
            PreparedStatement preparedStatement = connection.prepareStatement(CREATE_QUERY);
            preparedStatement.setString(1, name);
            preparedStatement.setDouble(2, price);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addItem(Item item) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "9537");
            PreparedStatement preparedStatement = connection.prepareStatement(CREATE_QUERY);
            preparedStatement.setString(1, item.getName());
            preparedStatement.setDouble(2, item.getPrice());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateItem(Item item) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "9537");
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_QUERY);
            preparedStatement.setString(1, item.getName());
            preparedStatement.setDouble(2, item.getPrice());
            preparedStatement.setLong(3, item.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteItem(Long id) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "9537");
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_QUERY);
            preparedStatement.setDouble(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
