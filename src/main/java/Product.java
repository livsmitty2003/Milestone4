//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

public class Product implements Comparable<Product>, Discount {
    public String name;
    public String description;
    public double price;
    public int quantity;
    String lineSeparator = System.lineSeparator();

    public Product(String name, String description, double price, int quantity) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
    }

    public String toString() {
        String listItem = "Name: " + this.name + "\tDescription: " + this.description + "\tPrice: " + this.price + "\tQuantity: " + this.quantity + "\t" + this.lineSeparator;
        return listItem;
    }

    public void reduceQuantity() {
        --this.quantity;
    }

    public void increaseQuantity() {
        ++this.quantity;
        System.out.println("The  " + this.name + " has been returned.");
    }

    public int compareTo(Product o) {
        return this.name.compareToIgnoreCase(o.name);
    }

    public void onSale(String i) {
        System.out.println(i + this.lineSeparator);
    }
}
