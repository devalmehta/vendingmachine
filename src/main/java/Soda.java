package main.java;

public enum Soda implements Item {

    COKE("Coke",100), PEPSI("Pepsi", 100) , MOUNTAINDEW("Mountain Dew",100);

    public String name = "";
    public int price =0;

    Soda(String name, int price) {
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
