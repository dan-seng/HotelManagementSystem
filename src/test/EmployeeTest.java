import static org.junit.Assert.*;
import org.junit.Test;

public class EmployeeTest {

  @Test
  public void testValidEmployee() {
    // Arrange: Create a valid Employee instance.
    Employee employee = new Employee("John", "Doe", "Male", 30, "Developer", 60000.0);

    // Act & Assert: Verify all getter values.
    assertEquals("John", employee.getFirstName());
    assertEquals("Doe", employee.getLastName());
    assertEquals("Male", employee.getGender());
    assertEquals(30, employee.getAge());
    assertEquals("Developer", employee.getJobTitle());
    assertEquals(60000.0, employee.getSalary(), 0.001);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidAge() {
    // Act: Create an employee with an invalid age (0 or less).
    new Employee("John", "Doe", "Male", 0, "Developer", 60000.0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidSalary() {
    // Act: Create an employee with an invalid salary (0 or negative).
    new Employee("John", "Doe", "Male", 30, "Developer", 0.0);
  }

  @Test
  public void testToString() {
    // Arrange: Create an Employee instance.
    Employee employee = new Employee("Jane", "Doe", "Female", 28, "Manager", 75000.0);
    String expected = "Jane,Doe,Female,28,Manager,75000.0";

    // Act & Assert: Check that toString() returns the expected string.
    assertEquals(expected, employee.toString());
  }

  @Test
  public void testEqualsAndHashCode() {
    // Arrange: Create two identical employees and one different.
    Employee emp1 = new Employee("Alice", "Smith", "Female", 32, "Designer", 50000.0);
    Employee emp2 = new Employee("Alice", "Smith", "Female", 32, "Designer", 50000.0);
    Employee emp3 = new Employee("Bob", "Jones", "Male", 40, "Manager", 80000.0);

    // Act & Assert: emp1 and emp2 should be equal and share the same hash code.
    assertTrue(emp1.equals(emp2));
    assertEquals(emp1.hashCode(), emp2.hashCode());

    // emp1 should not be equal to emp3.
    assertFalse(emp1.equals(emp3));
  }
}
