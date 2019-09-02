package main.java;

/**
 * Enum for an item
 */
public enum Chocolate implements Item {
    HERSEY("Hersey", 100), TWIX("Twix", 100), KITKAT("Kitkat",100);
    public String name = "";
    public int price =0;

    Chocolate(String name, Integer price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public long getPrice() {
        return price;
    }
}
