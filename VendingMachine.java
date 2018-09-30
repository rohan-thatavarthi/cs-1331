/**
 * VendingMachine class
 *
 * @author rthatavarthi3
 */
public class VendingMachine {

    private static double totalSales;
    private VendingItem[][][] shelf;
    private int luckyChance;
    private Random rand;

    /**
     * Creates a VendingMachine Object
     */
    public VendingMachine() {

    }

    public VendingItem vend(String code) {

    }

    private boolean free() {
        return true;
    }

    public void restock() {

    }

    public static double getTotalSales() {
        return 0.0;
    }

    public int getNumberOfItems() {
        return 0;
    }
    
    public double getTotalValue() {
        return 0.0;
    }

    public int getLuckyChance() {
        return 0;
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