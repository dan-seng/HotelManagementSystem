/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author cx
 */
public class Food {
    private String[] menuItems = {"Shiro", "Thibsi", "Keyweth", "Dulet", "Pizza", "Burger", "Sandwich", "Fata", "Fulhaja", "BeyeAynet"};
    private double[] price = {75.0, 310.0, 200.0, 170.0, 550.0, 450.0, 350.0, 80.0, 85.0, 110.0};

    // Check consistency of arrays in constructor
    public Food() {
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

    // Added input validation for menu selection
    public double getPrice(int choice) {
        if (choice < 1 || choice > menuItems.length) {
            System.out.println("Invalid menu item number.");
            return 0;
        }
        return price[choice - 1];
    }
}



