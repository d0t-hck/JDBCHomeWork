package org.itstep.JdbcHW;

import org.itstep.JdbcHW.entity.Item;
import org.itstep.JdbcHW.service.DBService;
import org.itstep.JdbcHW.service.DBServiceImpl;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Manager {

    public static void main(String[] args) throws SQLException {

        DBService service = new DBServiceImpl();
        Scanner console = new Scanner(System.in);
        String input;
        Integer selector = 1;
        while (!selector.equals(0)) {
            printMenu();
            selector = console.nextInt();
            if (selector.equals(1)) {
                System.out.print("Insert name: ");
                String name = console.next();
                System.out.print("Insert price: ");
                input = console.next();
                input = input.replace(",", ".");
                int index = input.indexOf(".", input.indexOf(".") + 1);
                if (index == -1) {
                    service.addItem(name, Double.parseDouble(input));
                } else {
                    service.addItem(name, Double.parseDouble(input.substring(0, index)));
                }
            } else if (selector.equals(2)) {
                List<Item> itemList = service.getAllItems();
                System.out.println("ID\tName\tPrice");
                for (Item item : itemList) {
                    System.out.println(item.toString());
                }
            } else if (selector.equals(3)) {
                System.out.print("Insert ID: ");
                Long id = console.nextLong();
                service.deleteItem(id);
            }
        }
    }

    public static void printMenu() {
        System.out.println("PRESS [1] TO ADD ITEMS\n" +
                "PRESS [2] TO LIST ITEMS\n" +
                "PRESS [3] TO DELETE ITEMS\n" +
                "PRESS [0] TO EXIT");
    }
}
