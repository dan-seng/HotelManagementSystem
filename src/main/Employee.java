/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author cx
 */
import java.util.Objects;

public class Employee {
    private String firstName;
    private String lastName;
    private String gender;
    private int age;
    private String jobTitle;
    private double salary;

    // Added basic validation for age and salary
    public Employee(String firstName, String lastName, String gender, int age, String jobTitle, double salary) {
        if (age <= 0) {
            throw new IllegalArgumentException("Age must be positive.");
        }
        if (salary <= 0) {
            throw new IllegalArgumentException("Salary must be positive.");
        }
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.age = age;
        this.jobTitle = jobTitle;
        this.salary = salary;
    }

    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getGender() { return gender; }
    public String getJobTitle() { return jobTitle; }
    public double getSalary() { return salary; }
    public int getAge() { return age; }

    @Override
    public String toString() {
        return firstName + "," + lastName + "," + gender + "," + age + "," + jobTitle + "," + salary;
    }
    
    // Overridden equals() and hashCode() methods
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Employee other = (Employee) obj;
        return age == other.age &&
               Double.compare(other.salary, salary) == 0 &&
               firstName.equals(other.firstName) &&
               lastName.equals(other.lastName) &&
               gender.equals(other.gender) &&
               jobTitle.equals(other.jobTitle);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, gender, age, jobTitle, salary);
    }
}


