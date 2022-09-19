package q1ex5;

import java.util.*;

public class Item {

    private String name, type;
    private double cost;
    private static ArrayList<Item> completeItemList = new ArrayList();

    public Item(String name, String type, double cost) {
        this.name = name;
        this.type = type;
        this.cost = cost;
        completeItemList.add(this);
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public double getCost() {
        return cost;
    }

    public String describe() {
        // Returns a human-readable representation of the Item instance
        return String.format("Item {\n\tname: %s,\n\ttype: %s, \n\tcost: %.2f\n}", name, type, cost);
    }

    public static Item getItem(int index) {
        return completeItemList.get(index);
    }

    public static void printAllItems() {
        // Prints all items in the store
        System.out.println("<ItemList>");
        for (Item i : completeItemList) {
            System.out.println(i.describe());
        }
        System.out.println("</ItemList>");
    }
}
