//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

public class Weapon extends Product implements Discount {
    public Weapon(String name, String description, double price, int quantity) {
        super(name, description, price, quantity);
    }

    public void onSale(String i) {
        System.out.println(i + this.lineSeparator);
    }
}
