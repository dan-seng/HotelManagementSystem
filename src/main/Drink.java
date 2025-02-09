/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author cx
 */
public class Drink {
    private String[] menuItems = {"Tea", "Coffee", "Milk", "Makyato", "1L Water", "Pepsi", "Coca Cola", "Beer", "Wine", "Whiskey"}; 
    private double[] price = {5.0, 10.0, 25.0, 25.0, 30.0, 40.0, 40.0, 70.0, 1000.0, 2500.0};

    // Check consistency of arrays in constructor
    public Drink() {
        if (menuItems.length != price.length) {
            throw new IllegalArgumentException("Menu items and prices arrays must match in length.");
        }
    }

    // Formatted menu output
    public void showMenu() {
        System.out.println("--------------------------------------------------");
        System.out.printf("%-5s %-20s %-10s%n", "No.", "Item", "Price (Birr)");
        System.out.println("--------------------------------------------------");
        for (int i = 0; i < menuItems.length; i++) {
            System.out.printf("%-5d %-20s %-10.2f%n", i + 1, menuItems[i], price[i]);
        }
        System.out.println("--------------------------------------------------");
    }

    public String[] getMenuItems() { return menuItems; }

    // Input validation in getPrice()
    public double getPrice(int choice) {
        if (choice < 1 || choice > menuItems.length) {
            System.out.println("Invalid menu item number.");
            return 0;
        }
        return price[choice - 1];
    }
}
