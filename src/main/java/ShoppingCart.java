//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

public class ShoppingCart {
    private String name;
    private String description;
    private double price;

    public ShoppingCart(String name, String description, double price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public void addItem() {
        System.out.println("The following item has been added to your cart: " + this.name);
    }

    public void emptyCart() {
        System.out.println("Your cart is empty.");
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String toString() {
        String listItem = this.name;
        return listItem;
    }
}
