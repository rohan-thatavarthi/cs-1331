import java.util.Random;

public enum VendingItem {
    Lays(1.50), Doritos(1.50), Coke(2.50), Ramblin_Reck_Toy(180.75),
    Rubiks_Cube(30.00), Rat_cap(15.00),FASET_Lanyard(10.00),
    Graphic_Calculator(120.00), UGA_Diploma(0.10), Pie(3.14), Clicker(55.55),
    Cheetos(1.25), Sprite(2.50), Red_Bull(4.75), Ramen(3.15), Cold_Pizza(0.99);

    private final double price;
    
    VendingItem(double price) {

        this.price = price;
    }
    public double getPrice() {
        return this.price;
    }
    public String toString() {
        String output = String.format("%s: %10.02f",name(),getPrice());
        return output;
    }
    public static void main(String[] args) {
        System.out.println(VendingItem.values().length);
        Random rand = new Random();
        VendingItem[][][] shelf =  new VendingItem[6][3][5];
        for (int i = 0; i < shelf.length; i++){
            for (int j = 0; j < shelf[i].length; j++){
                for (int k = 0; k < shelf[i][j].length; k++){
                    shelf[i][j][k] = VendingItem.values()[rand.nextInt(16)];
                    System.out.println(shelf[i][j][k].getPrice());
                }
            }
        }

        double totValue = 0;
        for (int i = 0; i < shelf.length; i++){
            for (int j = 0; j < shelf[i].length; j++){
                for (int k = 0; k < shelf[i][j].length; k++){
                    totValue = totValue + shelf[i][j][k].getPrice();
                }
            }
        }
        System.out.println(totValue);
    }
}