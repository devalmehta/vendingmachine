package vendingmachine;

import main.java.*;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VendingMachineTest {

    private static VendingMachineImpl vm;

    @BeforeClass
    public static void setUp() {
        vm = new VendingMachineImpl(createCashInventory(), createItemInventory());
    }

    private static Map<Item, Integer> createItemInventory() {
        Map<Item, Integer> itemInventory = new HashMap<>();
        itemInventory.put(Chips.CHEETOS, 5);
        itemInventory.put(Chips.FRITOS, 5);
        itemInventory.put(Chips.LAYS, 5);
        itemInventory.put(Chips.RUFFLE, 5);
        itemInventory.put(Soda.COKE, 5);
        itemInventory.put(Soda.MOUNTAINDEW, 5);
        itemInventory.put(Soda.PEPSI, 5);
        itemInventory.put(Chocolate.HERSEY, 5);
        itemInventory.put(Chocolate.KITKAT, 5);
        itemInventory.put(Chocolate.TWIX, 5);
        return itemInventory;
    }

    private static Map<Money, Integer> createCashInventory() {
        Map<Money, Integer> cashInventory = new HashMap<>();
        cashInventory.put(Coin.PENNY, 5);
        cashInventory.put(Coin.NICKLE, 5);
        cashInventory.put(Coin.DIME, 5);
        cashInventory.put(Coin.QUARTER, 5);
        cashInventory.put(Bill.ONE, 5);
        cashInventory.put(Bill.FIVE, 5);
        cashInventory.put(Bill.TEN, 5);
        return cashInventory;
    }

    @Test
    public void testPrintInventoryStatus() {
        vm.printInventoryStatus();
    }

    @Test
    public void testItemWithExactChange() {
        long price = vm.selectAnItem(Chips.CHEETOS);
        assertEquals(80, price, "Price of an item: " + Chips.CHEETOS.getName() + "is"+ price);
        List<Money> moneyList = new ArrayList<>();
        moneyList.add(Coin.QUARTER);
        moneyList.add(Coin.QUARTER);
        moneyList.add(Coin.QUARTER);
        moneyList.add(Coin.NICKLE);
        long refund = vm.acceptMoney(moneyList);
        assertEquals(0,refund);
        assertEquals(4, vm.getItemInventoryCount(Chips.CHEETOS), Chips.CHEETOS.getName() +"'s remaining count is "+vm.getItemInventoryCount(Chips.CHEETOS));
    }

    @Test
    public void testItemWithMoreChange() {
        long price = vm.selectAnItem(Chips.LAYS);
        List<Money> moneyList = new ArrayList<>();
        moneyList.add(Bill.ONE);
        long refund = vm.acceptMoney(moneyList);
        assertEquals(10, refund, refund +" is given");
    }
}
