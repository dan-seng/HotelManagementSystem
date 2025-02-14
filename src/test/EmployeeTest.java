import static org.junit.Assert.*;
import org.junit.Test;

public class EmployeeTest {

  @Test
  public void testValidEmployee() {
    Employee employee = new Employee("Daniel", "Gidey", "Male", 21, "Developer", 60000.0);
    assertEquals("Daniel", employee.getFirstName());
    assertEquals("Gidey", employee.getLastName());
    assertEquals("Male", employee.getGender());
    assertEquals(21, employee.getAge());
    assertEquals("Developer", employee.getJobTitle());
    assertEquals(60000.0, employee.getSalary(), 0.001);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidAge() {
    new Employee("John", "Doe", "Male", 0, "Developer", 60000.0);
  }
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidSalary() {
    new Employee("Daniel", "Gidey", "Male", 21, "Developer", 0.0);
  }
  @Test
  public void testToString() {
    Employee employee = new Employee("Hluf", "Gmeskel", "male", 24, "Manager", 75000.0);
    String expected = "Hluf,Gmeskel,male,24,Manager,75000.0";
    assertEquals(expected, employee.toString());
  }

  @Test
  public void testEqualsAndHashCode() {
    Employee emp1 = new Employee("Hermela", "Teklay", "Female", 24, "Designer", 50000.0);
    Employee emp2 = new Employee("Hermela", "Teklay", "Female", 24, "Designer", 50000.0);
    Employee emp3 = new Employee("Eden", "Kidane", "Female", 24, "Manager", 80000.0);
    assertTrue(emp1.equals(emp2));
    assertEquals(emp1.hashCode(), emp2.hashCode());
    // emp1 should not be equal to emp3.
    assertFalse(emp1.equals(emp3));
  }
}
