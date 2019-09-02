package main.java;

/**
 * Bill implements money's method
 */
public enum Bill implements Money {

    // money is in cents
    ONE(100), FIVE(500), TEN(1000);

    private int denomination;

    /**
     * Private constructor for the enum
     * @param denomination denomination of bill's type
     */
    Bill(int denomination) {
        this.denomination = denomination;
    }

    /**
     * Get denomination
     * @return the denomination
     */
    public int getDenomination(){
        return denomination;
    }
}
