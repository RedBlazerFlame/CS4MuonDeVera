package q1ex5;
import java.util.*;

public class Q1Ex5 {
  public static void main(String[] args) {
    // Create items
    // Since we are not adding or removing items from this list, we can
    // store it in a regular array
    Item[] items = {
        new Item("Burger", "food", 50),
        new Item("Fries", "food", 30),
        new Item("Fried Chicken", "food", 70),
        new Item("Shampoo", "toiletries", 120),
        new Item("Soap", "toiletries", 65),
        new Item("Toothpaste", "toiletries", 95),
        new Item("T-shirt", "clothes", 200),
        new Item("Jeans", "clothes", 1200),
        new Item("Shoes", "clothes", 2300),
    };

    // Create Stores
    Store mcdo = new Store("McDo");
    Store watsons = new Store("Watsons");
    Store mall = new Store("Supermall");

    mcdo.addItem(items[0]);
    mcdo.addItem(items[1]);
    mcdo.addItem(items[2]);

    watsons.addItem(items[3]);
    watsons.addItem(items[4]);
    watsons.addItem(items[5]);

    mall.addItem(items[0]);
    mall.addItem(items[1]);
    mall.addItem(items[3]);
    mall.addItem(items[4]);
    mall.addItem(items[5]);
    mall.addItem(items[6]);
    mall.addItem(items[7]);
    mall.addItem(items[8]);

    mall.filterType("food");
    mall.filterCheap(500.0);
    mall.filterExpensive(1000.0);

    mcdo.sellItem(0);
    mcdo.sellItem(50);
    watsons.sellItem("Soap");
    watsons.sellItem("Mouthwash");
    mall.sellItem(items[6]);
    mall.sellItem(items[2]);

    // Check final earnings
    Store.printStats();
  }
}
