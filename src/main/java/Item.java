package main.java;

/*
Item interface for the vending machine
 */
public interface Item {
    /*
        Get the name
     */
    String getName();

    /**
     * Get the price
     * @return returns the price of an item
     */
    long getPrice();
}
