package q1ex5;

import java.util.*;

public class Store {

    private String name;
    private double earnings;
    private ArrayList<Item> itemList;
    private static ArrayList<Store> storeList = new ArrayList();

    public Store(String a_name) {
        // Initialize name to parameter and earnings to zero
        // Initialize itemList as a new ArrayList
        // add 'this' store to storeList
        name = a_name;
        earnings = 0.0;
        itemList = new ArrayList<>();
        storeList.add(this);
    }

    public String getName() {
        return name;
    }

    public double getEarnings() {
        return earnings;
    }
    
    private void sellItemSurelyInStore(Item i) {
        // This method assumes that an item is in the store already
        // This method is called from within other methods, such as both overloads of sellItem

        // We will add the cost of the item to the earnings and print a statement indicating the selling of the item
        earnings += i.getCost();
        System.out.printf("Item sold. Item info: %s%n", i.describe());
    }

    public void sellItem(int index) {
        // check if index is within the size of the itemList (if not, print statement that there are only x items in the store)
        // get Item at index from itemList and add its cost to earnings
        // print statement indicating the sale
        int numItems = itemList.size();

        if (index >= numItems) {
            System.out.printf("There are only %d items in the store\n", numItems);
        } else {
            sellItemSurelyInStore(itemList.get(index));
        }
    }

    public void sellItem(String name) {
        // check if Item with given name is in the itemList (you will need to loop over itemList) (if not, print statement that the store doesn't sell it)
        // get Item from itemList and add its cost to getEarnings
        // print statement indicating the sale

        // Note: a HashMap could reduce the time complexity of this method to O(1)
        // To keep things simple, we'll perform an O(n) linear search through the item list
        for (Item i : itemList) {
            if (i.getName().equals(name)) {
                sellItemSurelyInStore(i);
                return;
            }
        }

        System.out.println("Item not found");
    }

    public void sellItem(Item i) {
        // check if Item i exists in the store (there is a method that can help with this) (if not, print statement that the store doesn't sell it)
        // get Item i from itemList and add its cost to getEarnings
        // print statement indicating the sale
        
        // Note: a HashMap could reduce the time complexity of this method to O(1)
        // To keep things simple, we'll perform an O(n) linear search through the item list
        if (itemList.contains(i)) {
            sellItemSurelyInStore(i);
        } else {
            System.out.println("Item not found");
        }
    }

    public void addItem(Item i) {
        // add Item i to store's itemList
        itemList.add(i);
    }

    public void filterType(String type) {
        // loop over itemList and print all items with the specified type
        System.out.printf("<FilterType type=\"%s\">%n", type);
        for(Item i : itemList) {
            if(i.getType().equals(type)) {
                System.out.println(i.describe());
            }
        }
        System.out.println("</FilterType>");
    }

    public void filterCheap(double maxCost) {
        // loop over itemList and print all items with a cost lower than or equal to the specified value
        System.out.printf("<FilterCheap maxCost=\"%.2f\">%n", maxCost);
        for(Item i : itemList) {
            if(i.getCost() <= maxCost) {
                System.out.println(i.describe());
            }
        }
        System.out.println("</FilterCheap>");
    }

    public void filterExpensive(double minCost) {
        // loop over itemList and print all items with a cost higher than or equal to the specified value
        System.out.printf("<FilterExpensive minCost=\"%.2f\">%n", minCost);
        for(Item i : itemList) {
            if(i.getCost() >= minCost) {
                System.out.println(i.describe());
            }
        }
        System.out.println("</FilterExpensive>");
    }
    
    public String describe() {
        // Returns a human-readable representation of the Store instance
        return String.format("Store {\n\tname: %s,\n\nearnings: %.2f\n}", name, earnings);
    }

    public static void printStats() {
        // loop over storeList and print the name and the earnings'Store.java'
        System.out.println("<StoreStats>");
        for(Store s : storeList) {
            System.out.println(s.describe());
        }
        System.out.println("</StoreStats>");
    }
}
