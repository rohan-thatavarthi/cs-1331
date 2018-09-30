import java.util.Random;
/**
 * VendingMachine class
 *
 * @author rthatavarthi3
 */
public class VendingMachine {
    // Total amount of money made
    private static double totalSales = 0;
    private VendingItem[][][] shelf =  new VendingItem[6][3][5];
    // % Chance to get free item on current vend() call
    private int luckyChance = 0;
    // Creates random number
    private Random rand = new Random();

    /**
     * Creates a VendingMachine Object
     */
    public VendingMachine() {
        restock();
    }

    public VendingItem vend(String code) {

    }

    private boolean free() {
        return true;
    }

    public void restock() {
        int venLen= VendingItem.value().length;
        for (int i = 0; i < shelf.length; i++){
            for (int j = 0; j < shelf[i].length; j++){
                for (int k = 0; k < shelf[i][j].length; k++){
                    shelf[i][j][k] = VendingItem.values()[rand.nextInt(venLen)];
                }
            }
        }
    }

    public static double getTotalSales() {
        return totalSales;
    }

    public int getNumberOfItems() {
        int numItems = 0;
        for (int i = 0; i < shelf.length; i++){
            for (int j = 0; j < shelf[i].length; j++){
                for (int k = 0; k < shelf[i][j].length; k++){
                    numItems++;
                }
            }
        }
        return numItems;
    }
    
    public double getTotalValue() {
        double totValue = 0; 
        for (int i = 0; i < shelf.length; i++){
            for (int j = 0; j < shelf[i].length; j++){
                for (int k = 0; k < shelf[i][j].length; k++){
                    totValue = totValue + shelf[i][j][k].getPrice();
                }
            }
        }
        return totValue;
    }

    public int getLuckyChance() {
        return luckyChance;
    }

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
        return s.toString();
    }

}