/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author cx
 */

import java.util.Scanner;

public class Hotel {
    public Room[] rooms;
    private Customer[] customers;
    public Employee[] employees;
    private int customerCount;
    private int employeeCount;

    public Hotel(int numRooms) {
        // Initialize rooms before loading file data
        rooms = new Room[numRooms];
        for (int i = 0; i < numRooms; i++) {
            String roomType = (i % 3 == 0) ? "Suite" : (i % 2 == 0) ? "Double" : "Single";
            double roomPrice = (i % 3 == 0) ? 1500.0 : (i % 2 == 0) ? 850.00 : 400.0;
            rooms[i] = new Room(i + 1, roomType, roomPrice);
        }
        customers = new Customer[100];
        employees = new Employee[100];
        customerCount = 0;
        employeeCount = 0;
        loadExistingData();
    }

    private void loadExistingData() {
        loadCustomers();
        loadEmployees();
        loadRooms();
    }

    private void loadCustomers() {
        String[] data = FileManager.readFile("customers.txt");
        for (String line : data) {
            if (line != null && !line.trim().isEmpty()) {
                String[] parts = line.split(",");
                customers[customerCount++] = new Customer(
                        Integer.parseInt(parts[0]), parts[1], parts[2],
                        Integer.parseInt(parts[3]), parts[4], Integer.parseInt(parts[5]));
            }
        }
    }

    private void loadEmployees() {
        String[] data = FileManager.readFile("employees.txt");
        for (String line : data) {
            if (line != null && !line.trim().isEmpty()) {
                String[] parts = line.split(",");
                employees[employeeCount++] = new Employee(
                        parts[0], parts[1], parts[2],
                        Integer.parseInt(parts[3]), parts[4], Double.parseDouble(parts[5]));
            }
        }
    }

    private void loadRooms() {
        String[] data = FileManager.readFile("rooms.txt");
        for (String line : data) {
            if (line != null && !line.trim().isEmpty()) {
                String[] parts = line.split(",");
                int roomNum = Integer.parseInt(parts[0]);
                if (roomNum <= rooms.length) { // Check if room number is within bounds
                    Room room = new Room(roomNum, parts[1], Double.parseDouble(parts[2]));
                    if (parts[3].equalsIgnoreCase("Yes")) {
                        room.occupyRoomWithoutFileUpdate(); // Updated: method added in Room class
                    }
                    rooms[roomNum - 1] = room;
                } else {
                    System.out.println("Skipping room " + roomNum + " (out of bounds).");
                }
            }
        }
        updateRoomFile();
    }

    /*
     * private void loadRooms() {
     * String[] data = FileManager.readFile("rooms.txt");
     * for (String line : data) {
     * if (line != null && !line.trim().isEmpty()) {
     * String[] parts = line.split(",");
     * int roomNum = Integer.parseInt(parts[0]);
     * Room room = new Room(roomNum, parts[1], Double.parseDouble(parts[2]));
     * if (parts[3].equalsIgnoreCase("Yes")) {
     * room.occupyRoomWithoutFileUpdate(); // Updated: method added in Room class
     * }
     * rooms[roomNum - 1] = room;
     * }
     * }
     * updateRoomFile();
     * }
     */

    public void bookRoom(Customer customer) {
        int roomNumber = customer.getRoomNumber();
        if (roomNumber < 1 || roomNumber > rooms.length) {
            System.out.println("Invalid room number.");
            return;
        }
        Room room = rooms[roomNumber - 1];
        if (!room.isOccupied()) {
            room.occupyRoom();
            customers[customerCount++] = customer;
            updateCustomerFile();
            updateRoomFile();
            System.out.println("Room " + room.getRoomNumber() + " booked for "
                    + customer.getFirstName() + " " + customer.getLastName());
        } else {
            System.out.println("Room " + roomNumber + " is already occupied.");
        }
    }

    public void removeCustomer(String firstName, String lastName) {
        for (int i = 0; i < customerCount; i++) {
            if (customers[i].getFirstName().equalsIgnoreCase(firstName) &&
                    customers[i].getLastName().equalsIgnoreCase(lastName)) {
                vacateRoom(customers[i].getRoomNumber());
                customers[i] = customers[--customerCount]; // Shift last customer into removed slot
                updateCustomerFile();
                System.out.println("Customer " + firstName + " " + lastName + " removed.");
                return;
            }
        }
        System.out.println("Customer not found.");
    }

    public void addEmployee(Employee employee) {
        employees[employeeCount++] = employee;
        updateEmployeeFile();
        System.out.println("Employee " + employee.getFirstName() + " "
                + employee.getLastName() + " added.");
    }

    // NEW: Remove employee method
    public void removeEmployee(String firstName, String lastName) {
        for (int i = 0; i < employeeCount; i++) {
            if (employees[i].getFirstName().equalsIgnoreCase(firstName) &&
                    employees[i].getLastName().equalsIgnoreCase(lastName)) {
                employees[i] = employees[--employeeCount]; // Shift last employee into removed slot
                updateEmployeeFile();
                System.out.println("Employee " + firstName + " " + lastName + " removed.");
                return;
            }
        }
        System.out.println("Employee not found.");
    }

    private void vacateRoom(int roomNumber) {
        if (roomNumber < 1 || roomNumber > rooms.length)
            return;
        rooms[roomNumber - 1].vacateRoom();
        updateRoomFile();
    }

    // Always overwrite file (append = false) for consistency
    private void updateCustomerFile() {
        String[] data = new String[customerCount];
        for (int i = 0; i < customerCount; i++) {
            data[i] = customers[i].toString();
        }
        FileManager.writeFile("customers.txt", data, false);
    }

    private void updateRoomFile() {
        String[] data = new String[rooms.length];
        for (int i = 0; i < rooms.length; i++) {
            data[i] = rooms[i].toString();
        }
        FileManager.writeFile("rooms.txt", data, false);
    }

    private void updateEmployeeFile() {
        String[] data = new String[employeeCount];
        for (int i = 0; i < employeeCount; i++) {
            data[i] = employees[i].toString();
        }
        FileManager.writeFile("employees.txt", data, false);
    }

    // Formatted display for customers
    public void showCustomersInformation() {
        System.out.println("\n===== Customers Information =====");
        System.out.printf("%-5s %-10s %-10s %-5s %-15s %-8s%n", "ID", "FirstName", "LastName", "Age", "Phone",
                "RoomNo");
        System.out.println("--------------------------------------------------------");
        String[] data = FileManager.readFile("customers.txt");
        for (String line : data) {
            if (line != null && !line.trim().isEmpty()) {
                String[] parts = line.split(",");
                System.out.printf("%-5s %-10s %-10s %-5s %-15s %-8s%n",
                        parts[0], parts[1], parts[2], parts[3], parts[4], parts[5]);
            }
        }
    }

    // Formatted display for employees
    public void showEmployeesInformation() {
        System.out.println("\n===== Employees Information =====");
        System.out.printf("%-10s %-10s %-8s %-5s %-12s %-8s%n", "FirstName", "LastName", "Gender", "Age", "JobTitle",
                "Salary");
        System.out.println("-----------------------------------------------------------------");
        String[] data = FileManager.readFile("employees.txt");
        for (String line : data) {
            if (line != null && !line.trim().isEmpty()) {
                String[] parts = line.split(",");
                System.out.printf("%-10s %-10s %-8s %-5s %-12s %-8s%n",
                        parts[0], parts[1], parts[2], parts[3], parts[4], parts[5]);
            }
        }
    }

    // Formatted display for available rooms
    public void showAvailableRooms() {
        System.out.println("\n===== Available Rooms =====");
        System.out.printf("%-10s %-10s %-12s%n", "Room No.", "Type", "Price (Birr)");
        System.out.println("--------------------------------------");
        for (Room room : rooms) {
            if (!room.isOccupied()) {
                System.out.printf("%-10d %-10s %-12.2f%n",
                        room.getRoomNumber(), room.getRoomType(), room.getRoomPrice());
            }
        }
    }

    public boolean isRoomBooked(int roomNumber) {
        if (roomNumber < 1 || roomNumber > rooms.length) {
            return false; // Invalid room number
        }
        return rooms[roomNumber - 1].isOccupied();
    }

    public int getEmployeeCount() {
        return employeeCount;
    }

}
