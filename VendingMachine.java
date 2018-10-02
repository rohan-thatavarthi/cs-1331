import java.util.Random;
/**
 * VendingMachine class
 *
 * @author rthatavarthi3
 * @version 1.0
 */
public class VendingMachine {
    // Total amount of money made
    private static double totalSales = 0;
    // Array of VendingItem objects
    private VendingItem[][][] shelf =  new VendingItem[6][3][5];
    // % Chance to get free item on current vend() call
    private int luckyChance = 0;
    // Creates random number
    private Random rand = new Random();

    /**
     * Vending Machine constructor, zero arguments
     */
    public VendingMachine() {
        restock();
    }

    /**
     * Outputs object in desired location of the vending machine
     * @param code location of item user would like
     * @return instance of VendingItem or null
     */
    public VendingItem vend(String code) {
        char[] input = code.toCharArray();
        boolean validLetter = 'A' <= (int) input[0] && (int) input[0] <= 'Z';
        boolean validNumber = '0' <= (int) input[1] && (int) input[1] <= '9';
        boolean rowInBounds = ((int) input[0] - 'A') < shelf.length;
        int intInput = (int) input[1] - '0' - 1;
        boolean colInBounds = 0 <= intInput && intInput < shelf[0].length;
        VendingItem output = null;

        if (validLetter && validNumber && rowInBounds && colInBounds) {
            int row = (int) input[0] - 'A';
            int col = (int) input[1] - '0' - 1;
            output =  shelf[row][col][0];

            // Call Method to reorder the stuff in the position
            reorder(row, col);

            if (output == null) {
                System.out.println("Error: There are no items. Sorry!");
            } else if (free()) {
                System.out.println("Congrats! You get this item for free.");
            } else {
                totalSales = totalSales + output.getPrice();
            }
        } else {
            System.out.println("Error: Invalid code. Please try valid code.");
            output = null;
        }
        return output;
    }

    /**
     * Helper function to reorder rows and add nulls for items sold
     * @param row row # in vending machine where item was taken
     * @param col col # in vending machine where item was taken
     */
    private void reorder(int row, int col) {
        for (int k = 0; k < shelf[row][col].length - 1; k++) {
            shelf[row][col][k] = shelf[row][col][k + 1];
        }
        shelf[row][col][shelf[row][col].length - 1] = null;
    }

    /**
     * Lottery to see if user will get a free item
     * @return boolean value on whether user is or isn't waived fee
     */
    private boolean free() {
        if (rand.nextInt(100) < luckyChance) {
            luckyChance = 0;
            return true;
        } else {
            luckyChance++;
            return false;
        }
    }

    /**
     * Restocks all items in the vending machine
     */
    public void restock() {
        int venLen = VendingItem.values().length;
        for (int i = 0; i < shelf.length; i++) {
            for (int j = 0; j < shelf[i].length; j++) {
                for (int k = 0; k < shelf[i][j].length; k++) {
                    shelf[i][j][k] = VendingItem.values()[rand.nextInt(venLen)];
                }
            }
        }
    }

    /**
     * Getter function for total sales value
     * @return $ made selling items from vending machine after being restocked
     */
    public static double getTotalSales() {
        return totalSales;
    }

    /**
     * Getter function on how many items are in the vending machine currently
     * @return integer value of the total number of items
     */
    public int getNumberOfItems() {
        int numItems = 0;
        for (int i = 0; i < shelf.length; i++) {
            for (int j = 0; j < shelf[i].length; j++) {
                for (int k = 0; k < shelf[i][j].length; k++) {
                    if (shelf[i][j][k] != null) {
                        numItems++;
                    }
                }
            }
        }
        return numItems;
    }

    /**
     * Getter function to get the total monetary value of items in machine
     * @return double value of the total amount of money in items
     */
    public double getTotalValue() {
        double totValue = 0;
        for (int i = 0; i < shelf.length; i++) {
            for (int j = 0; j < shelf[i].length; j++) {
                for (int k = 0; k < shelf[i][j].length; k++) {
                    if (shelf[i][j][k] != null) {
                        totValue = totValue + shelf[i][j][k].getPrice();
                    }
                }
            }
        }
        return totValue;
    }

    /**
     * Getter function for luckyChance value
     * @return integer value of luckyChance variable
     */
    public int getLuckyChance() {
        return luckyChance;
    }

    /**
     * toString method for class
     * @return output string for class
     */
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("----------------------------------------------------------"
            + "------------\n");
        s.append("                            VendaTron 9000                "
            + "            \n");
        for (int i = 0; i < shelf.length; i++) {
            s.append("------------------------------------------------------"
                + "----------------\n");
            for (int j = 0; j < shelf[0].length; j++) {
                VendingItem item = shelf[i][j][0];
                String str = String.format("| %-20s ",
                    (item == null ? "(empty)" : item.name()));
                s.append(str);
            }
            s.append("|\n");
        }
        s.append("----------------------------------------------------------"
            + "------------\n");
        s.append(String.format("There are %d items with a total "
            + "value of $%.2f.%n", getNumberOfItems(), getTotalValue()));
        s.append(String.format("Total sales across vending machines "
            + "is now: $%.2f.%n", getTotalSales()));

        s.append(getLuckyChance());
        return s.toString();
    }

}