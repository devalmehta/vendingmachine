package main.java;

import java.util.HashMap;
import java.util.Map;

public class Inventory<T> {
    private Map<T, Integer> inventory = new HashMap<>();

    public void put(T item,  int count) {
        inventory.put(item, count);
    }

    public boolean hasItem(T item){
        return inventory.get(item) >0;
    }

    public void add(T item){
        int count = inventory.get(item);
        inventory.put(item, count+1);
    }

    public void deduct(T item) {
        if (hasItem(item)) {
            int count = inventory.get(item);
            inventory.put(item, count - 1);
        }
    }

    public int getQuantity(T item){
        Integer value = inventory.get(item);
        return value == null? 0 : value ;
    }

    public void printInventoryStatus() {
        inventory.forEach((key, value) -> System.out.println("Item: " + key + " has " + value + " remaining."));
    }
}
