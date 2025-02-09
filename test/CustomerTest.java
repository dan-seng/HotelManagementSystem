import static org.junit.Assert.*;
import org.junit.Test;

public class CustomerTest {

  @Test
  public void testValidCustomer() {
    // Arrange: Create a valid Customer instance.
    Customer customer = new Customer(1, "John", "Doe", 30, "1234567890", 101);

    // Act & Assert: Verify all getter values.
    assertEquals(1, customer.getId());
    assertEquals("John", customer.getFirstName());
    assertEquals("Doe", customer.getLastName());
    assertEquals(30, customer.getAge());
    assertEquals("1234567890", customer.getPhoneNumber());
    assertEquals(101, customer.getRoomNumber());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidAge() {
    // Age is 0 which should throw an exception.
    new Customer(2, "Jane", "Smith", 0, "1234567890", 102);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidPhoneNumber() {
    // Phone number is not 10 digits, should throw an exception.
    new Customer(3, "Bob", "Brown", 25, "12345678", 103);
  }

  @Test
  public void testEqualsAndHashCode() {
    // Arrange: Create two identical customers.
    Customer customer1 = new Customer(4, "Alice", "Green", 28, "0987654321", 104);
    Customer customer2 = new Customer(4, "Alice", "Green", 28, "0987654321", 104);

    // Act & Assert: They should be equal and have the same hashCode.
    assertTrue(customer1.equals(customer2));
    assertEquals(customer1.hashCode(), customer2.hashCode());
  }

  @Test
  public void testToString() {
    // Arrange: Create a customer.
    Customer customer = new Customer(5, "Eve", "White", 35, "1122334455", 105);
    String expected = "5,Eve,White,35,1122334455,105";

    // Act & Assert: The toString method should produce the expected string.
    assertEquals(expected, customer.toString());
  }
}
