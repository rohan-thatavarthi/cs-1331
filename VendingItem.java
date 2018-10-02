/**
 * VendingMachine class
 *
 * @author rthatavarthi3
 * @version 1.0
 */
public enum VendingItem {
    Lays(1.50), Doritos(1.50), Coke(2.50), Ramblin_Reck_Toy(180.75),
    Rubiks_Cube(30.00), Rat_cap(15.00), FASET_Lanyard(10.00),
    Graphic_Calculator(120.00), UGA_Diploma(0.10), Pie(3.14), Clicker(55.55),
    Cheetos(1.25), Sprite(2.50), Red_Bull(4.75), Ramen(3.15), Cold_Pizza(0.99);

    private final double price;

    /**
     * Creates a VendingMachine Object
     * @param price price of object
     */
    VendingItem(double price) {

        this.price = price;
    }

    /**
     * Getter function to get price of an object
     * @return price of the object
     */
    public double getPrice() {
        return this.price;
    }

    /**
     * Formats output string of object to output ENUM name & price
     * @return output Returns a properly formatted string
     */
    public String toString() {
        String output = String.format("%s: %.02f", name(), getPrice());
        return output;
    }
}