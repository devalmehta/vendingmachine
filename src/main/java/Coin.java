package main.java;

/**
 * Enum for coin which implements Money's methods
 */
public enum Coin implements Money{

    PENNY(1), NICKLE(5), DIME(10), QUARTER(25);

    private int denomination;

    /**
     * Private constructor for an enum
     * @param denomination the amount associated with enum type
     */
    Coin(int denomination) {
        this.denomination = denomination;
    }

    /**
     * Get the denominator
     * @return denomination
     */
    public int getDenomination(){
        return denomination;
    }
}
