//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    //Writes product inventory array to 'products.txt'
    static void writeToFile(Product[] arr) throws IOException
    {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File("products.txt"), arr);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static void main(String[] args) throws IOException {

        //Declare variables/Arrays
        String lineSeparator = System.lineSeparator();
        double points = 100.0;
        ShoppingCart[] cartArray = new ShoppingCart[7];
        Product[] prodArray = new Product[]{new Armor("Super Suit", "Protects wearer from all types of devestation.", 50.0, 6), new Armor("Lazy Shell", "Hide under it for absolute invisibility.", 30.0, 4), new Weapon("Frying Pan", "Slay any attacker that comes your way.", 25.0, 7), new Weapon("Punch Glove", "Knock any foe down with a triple punch.", 30.0, 3), new Health("Chicken Leg", "Enjoy a protein punch.", 20.0, 2), new Health("Spinach", "Up your vitamins with rich greens.", 20.0, 2), new Health("Elixir", "Supercharge your tired self with a powerful potion", 20.0, 2)};

        //Sort array in alphabetical order
        Arrays.sort(prodArray);

        //Calls method that writes inventory list to 'products.txt' and to console
        writeToFile(prodArray);

        //prints inventory list from 'products.txt'
        try {
            File myObj = new File("products.txt");
            Scanner myReader = new Scanner(myObj);
            int k = 0;
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
            }
            myReader.close();

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }


        //Creates shopping cart
        cartArray[0] = new ShoppingCart("null", "null", 0.0);
        Scanner obj = new Scanner(System.in);
        System.out.println("Welcome to the Game Stop. Would you like to see a list of products? 'y' for yes; 'n' for no");
        String choice = obj.nextLine();
        if (choice.equals("y")) {
            for(int i = 0; i < prodArray.length; ++i) {
                System.out.print(i + 1 + ". " + prodArray[i].toString() + " " + lineSeparator);
            }

            System.out.println(lineSeparator + "Press 'p' to purchase" + lineSeparator + "Press 'c' to check credits" + lineSeparator + "Press 'e' to exit." + lineSeparator + "Press 's' to see what's on sale.");
            choice = obj.nextLine();
            if (choice.equals("c")) {
                System.out.println("You have " + points + " points.");
            }

            if (choice.equals("s")) {
                System.out.println("The following items are on sale: " + lineSeparator);
                Sale(prodArray[3]);
                Sale(prodArray[4]);
            }

            if (choice.equals("p")) {
                System.out.println("Enter the ID of the prodArray you wish to purchase.");
                int choiceID = obj.nextInt();
                int item = choiceID - 1;
                points -= prodArray[item].price;
                prodArray[item].reduceQuantity();
                cartArray[0] = new ShoppingCart(prodArray[item].name, prodArray[item].description, prodArray[item].price);
                PrintStream var10000 = System.out;
                String var10001 = cartArray[0].getName();
                var10000.println("The following item is in your cart: " + var10001 + ".  You're point balance is: " + points + System.lineSeparator());
                System.out.println("Buyer's remorse? Click 'y' to return. Click 'l' to check out the inventory");
                choice = obj.next();
                if (choice.equals("y")) {
                    prodArray[item].increaseQuantity();
                    points += prodArray[item].price;
                    cartArray[0] = new ShoppingCart("empty", "empty", 0.0);
                    var10000 = System.out;
                    var10001 = cartArray[0].getName();
                    var10000.println("You're cart is: " + var10001 + ".  You're point balance is: " + points + System.lineSeparator());
                }

                if (choice.equals("l")) {
                    for(int d = 0; d < prodArray.length; ++d) {
                        System.out.print(d + 1 + ". " + prodArray[d].toString() + " ");
                    }
                }

                if (choice.equals("e")) {
                    System.out.println("Thank you for checking out our inventory. Come back soon!");
                }
            }
        } else {
            System.out.println("Thanks for stopping in. Check in later to see what new items are in stock!");
        }

    }

    public static void Sale(Product saleItem) {
        saleItem.onSale(saleItem.name);
    }
}
