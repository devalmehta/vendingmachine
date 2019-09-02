package main.java;


import java.util.List;
import java.util.Map;

/**
 * Implementation of VendingMachine class
 */
public class VendingMachineImpl implements VendingMachine {

    private Inventory<Item> itemInventory = new Inventory<>();
    private Inventory<Money> cashInventory = new Inventory<>();

    private int currentDue = 0;

    /**
     * Get the current due
     * @return return amount remaining
     */
    private int getCurrentDue() {
        return currentDue;
    }

    /**
     * Sets current Due remaining
     * @param currentDue the amount that is due
     */
    private void setCurrentDue(int currentDue) {
        this.currentDue = currentDue;
    }

    /**
     * Constructor for Vending Machine
     * @param numberOfMoney Map for the Money to how many
     * @param numberOfItems Map for the items to how many
     */
    public VendingMachineImpl (Map<Money, Integer> numberOfMoney, Map<Item, Integer> numberOfItems) {
        initialize(numberOfMoney, numberOfItems);
    }

    /**
     * Initializes coins map and items map
     * @param numberOfMoney Map for the coins to how many
     * @param numberOfItems Map for the items to how many
     */
    private void initialize(Map<Money, Integer> numberOfMoney, Map<Item, Integer> numberOfItems) {
        numberOfMoney.forEach((k,v)-> cashInventory.put(k, v));
        numberOfItems.forEach((k,v) -> itemInventory.put(k, v));
    }

    /**
     * Select an item
     * @param item item that is selected
     */
    @Override
    public long selectAnItem(Item item) {

        if(itemInventory.getQuantity(item) >0 ){
            itemInventory.deduct(item);
        }
        return getPriceForAnItem(item);
    }

    /**
     * Gets the price of a given item
     * @param item item selected
     * @return the price of an item
     */
    @Override
    public long getPriceForAnItem(Item item) {
        long price = 0;
        if(itemInventory.hasItem(item)) {
            price = item.getPrice();
        }
        setCurrentDue((int) price);
        return price;
    }

    /**
     * Accepts the due!!
     * @param money money due
     */
    @Override
    public long acceptMoney(List<Money> money) {

        money.forEach(money1 -> cashInventory.add(money1));
        int totalInsertedMoney = money.stream().mapToInt(Money::getDenomination).sum();
        if(totalInsertedMoney > getCurrentDue() ) {
           return refund(totalInsertedMoney - getCurrentDue());
        }
        return 0;
    }

    /**
     * Give refund back
     * @param refund the amount refunded
     * @return the refund
     */
    @Override
    public long refund(int refund) {

        int remainingAmount = 0;
        if(refund >= Coin.QUARTER.getDenomination()) {
            refund = getRemainingAmount(refund, remainingAmount, Coin.QUARTER, 25);
        }
        if(refund >= Coin.DIME.getDenomination()) {
            refund  = getRemainingAmount(refund, remainingAmount, Coin.DIME, 10);
        }
        if(refund >= Coin.NICKLE.getDenomination()) {
            refund = getRemainingAmount(refund, remainingAmount, Coin.NICKLE, 5);
        }
        if(refund >= Coin.PENNY.getDenomination()) {
            refund = getRemainingAmount(refund, remainingAmount, Coin.PENNY, 1);
        }
        return refund;
    }

    /**
     * Supporting method to calculate the refund
     * @param refund amount to be refunded
     * @param remainingAmount what is remaining out of refund
     * @param coin coins available
     * @param i2 coin type
     * @return return the total from given coin i2
     */
    private int getRemainingAmount(int refund, int remainingAmount, Coin coin, int i2) {
        int coinTotal = 0;
        for (int i = 1; i < cashInventory.getQuantity(coin); i++) {
            cashInventory.deduct(coin);
            coinTotal = coinTotal + i2;
            if (coinTotal > remainingAmount) {
                coinTotal = coinTotal - i2;
                cashInventory.add(coin);
                remainingAmount = refund - coinTotal;
            }
        }
        return coinTotal;
    }

    /**
     * Prints inventory status
     */
    public void printInventoryStatus() {
        this.cashInventory.printInventoryStatus();
        this.itemInventory.printInventoryStatus();
    }

    /**
     * Get inventory count of a given item
     * @param item chips/soda/chocolate
     * @return number of given item available
     */
    public int getItemInventoryCount(Item item) {
       return itemInventory.getQuantity(item);
    }

    /**
     * Get inventor count of money
     * @param money quarters/dimes/nickles/pennies
     * @return return the count available
     */
    public int getMoneyInventoryCount(Money money) {
        return cashInventory.getQuantity(money);
    }
}
