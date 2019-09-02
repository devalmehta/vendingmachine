package main.java;

public enum Chips implements Item{

    LAYS("Lays",90), CHEETOS("Cheetos",80), RUFFLE("Ruffle",90), FRITOS("Fritos", 80);

    public String name = "";
    public int price =0;

    private Chips(String name, int price) {
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
