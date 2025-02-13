/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author cx
 */
import java.util.Scanner;

public class HotelMangementSystem {
    public static void main(String[] args) {
        // Using try-with-resources to ensure Scanner is closed properly
        try (Scanner scanner = new Scanner(System.in)) {
            Hotel hotel = new Hotel(100);
            Food food = new Food();
            Drink drink = new Drink();
            boolean exit = false;

            while (!exit) {
                displayMainMenu();
                System.out.print("Choose an option: ");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        hotel.showAvailableRooms();
                        break;
                    case 2:
                        bookRoomForCustomer(hotel, scanner);
                        break;
                    case 3:
                        removeCustomerFromHotel(hotel, scanner);
                        break;
                    case 4:
                        hotel.showCustomersInformation();
                        break;
                    case 5:
                        addEmployeeToHotel(hotel, scanner);
                        break;
                    case 6:
                        hotel.showEmployeesInformation();
                        break;
                    case 7:
                        orderFood(food, scanner);
                        break;
                    case 8:
                        orderToDrink(drink, scanner);
                        break;
                    case 9:
                        removeEmployeeFromHotel(hotel, scanner);
                        break;
                    case 0:
                        exit = true;
                        System.out.println("Exiting the system. Thank you for using the Hotel Management System.");
                        break;
                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            }
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    private static void displayMainMenu() {
        System.out.println("\n================= Hotel Management System ==================");
        System.out.println("1. Show Available Rooms");
        System.out.println("2. Book a Room");
        System.out.println("3. Remove a Customer");
        System.out.println("4. Show Customers Information");
        System.out.println("5. Add an Employee");
        System.out.println("6. Show Employees Information");
        System.out.println("7. Order Food");
        System.out.println("8. Order Drink");
        System.out.println("9. Remove an Employee"); // --- NEW: Option to remove an employee
        System.out.println("0. Exit");
        System.out.println("-------------------------------------------------------------");
    }

    public static void bookRoomForCustomer(Hotel hotel, Scanner scanner) {
        System.out.println("\n--- Booking a Room ---");
        System.out.print("Enter customer Id: ");
        int customerId = scanner.nextInt();
        System.out.print("Enter customer First Name: ");
        String firstName = scanner.next();
        System.out.print("Enter customer Last Name: ");
        String lastName = scanner.next();
        System.out.print("Enter customer Age: ");
        int age = scanner.nextInt();
        System.out.print("Enter customer Phone Number: ");
        String phone = scanner.next();
        System.out.print("Enter room number to book: ");
        int roomNumber = scanner.nextInt();
        Customer customer = new Customer(customerId, firstName, lastName, age, phone, roomNumber);
        hotel.bookRoom(customer);
    }

    public static void removeCustomerFromHotel(Hotel hotel, Scanner scanner) {
        System.out.println("\n--- Removing a Customer ---");
        System.out.print("Enter customer First Name: ");
        String firstName = scanner.next();
        System.out.print("Enter customer Last Name: ");
        String lastName = scanner.next();
        hotel.removeCustomer(firstName, lastName);
    }

    // NEW: Method to remove an employee
    public static void removeEmployeeFromHotel(Hotel hotel, Scanner scanner) {
        System.out.println("\n--- Removing an Employee ---");
        System.out.print("Enter employee First Name: ");
        String firstName = scanner.next();
        System.out.print("Enter employee Last Name: ");
        String lastName = scanner.next();
        hotel.removeEmployee(firstName, lastName);
    }

    public static void addEmployeeToHotel(Hotel hotel, Scanner scanner) {
        System.out.println("\n--- Adding a New Employee ---");
        System.out.print("Enter employee First Name: ");
        String firstName = scanner.next();
        System.out.print("Enter employee Last Name: ");
        String lastName = scanner.next();
        System.out.print("Enter employee Gender: ");
        String gender = scanner.next();
        System.out.print("Enter employee Age: ");
        int age = scanner.nextInt();
        System.out.print("Enter job title: ");
        String jobTitle = scanner.next();
        System.out.print("Enter salary: ");
        double salary = scanner.nextDouble();
        Employee employee = new Employee(firstName, lastName, gender, age, jobTitle, salary);
        hotel.addEmployee(employee);
    }

    public static void orderFood(Food food, Scanner scanner) {
        System.out.println("\n===== Food Menu =====");
        food.showMenu();
        System.out.println("Enter item number (0 to finish) to order food:");
        int item = scanner.nextInt();
        double total = 0;
        while (item != 0) {
            total += food.getPrice(item);
            System.out.println("Enter item number (0 to finish) to order food:");
            item = scanner.nextInt();
        }
        System.out.printf("Total amount to pay is: Birr %.2f%n", total);
    }

    public static void orderToDrink(Drink drink, Scanner scanner) {
        System.out.println("\n===== Drink Menu =====");
        drink.showMenu();
        System.out.println("Enter item number (0 to finish) to order drink:");
        int item = scanner.nextInt();
        double total = 0;
        while (item != 0) {
            total += drink.getPrice(item);
            System.out.println("Enter item number (0 to finish) to order drink:");
            item = scanner.nextInt();
        }
        System.out.printf("Total amount to pay is: Birr %.2f%n", total);
    }
}
