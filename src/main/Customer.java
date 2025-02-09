/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author cx
 */
import java.util.Objects;

public class Customer {
    private int id;
    private String firstName;
    private String lastName;
    private int age;
    private String phoneNumber;
    private int roomNumber;

    // Added validation for age and phone number format
    public Customer(int id, String firstName, String lastName, int age, String phoneNumber, int roomNumber) {
        if (age <= 0) {
            throw new IllegalArgumentException("Age must be positive.");
        }
        if (!phoneNumber.matches("\\d{10}")) {
            throw new IllegalArgumentException("Phone number must be 10 digits.");
        }
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.roomNumber = roomNumber;
    }

    public int getId() { return id; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public int getAge() { return age; }
    public String getPhoneNumber() { return phoneNumber; }
    public int getRoomNumber() { return roomNumber; }

    @Override
    public String toString() {
        return id + "," + firstName + "," + lastName + "," + age + "," + phoneNumber + "," + roomNumber;
    }
    
    // Overridden equals() and hashCode() methods
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Customer other = (Customer) obj;
        return id == other.id &&
               age == other.age &&
               roomNumber == other.roomNumber &&
               firstName.equals(other.firstName) &&
               lastName.equals(other.lastName) &&
               phoneNumber.equals(other.phoneNumber);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, age, phoneNumber, roomNumber);
    }
}


