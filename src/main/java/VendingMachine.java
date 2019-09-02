package main.java;

import java.util.List;

/**
 * Vending Machine interface
 */
public interface VendingMachine {

    /**
     * select an item from the vending machine
     */
    long selectAnItem(Item item);

    /**
     * Get the price for selected item
     * @param item item selected
     * @return return the price of the item
     */
    long getPriceForAnItem(Item item);

    /**
     * Accept money for the selected item
     */
    long acceptMoney(List<Money> money);

    /**
     * refund the remaining money
     * @return refund
     */
    long refund(int refund);

    /**
     * Get item inventory count
     */
    int getItemInventoryCount(Item item);
}
