import static org.junit.Assert.*;
import org.junit.Test;
public class CustomerTest {
  @Test
  public void testValidCustomer() {
    Customer customer = new Customer(1, "Hayle", "Abrha", 30, "1234567890", 101);
    assertEquals(1, customer.getId());
    assertEquals("John", customer.getFirstName());
    assertEquals("Doe", customer.getLastName());
    assertEquals(30, customer.getAge());
    assertEquals("1234567890", customer.getPhoneNumber());
    assertEquals(101, customer.getRoomNumber());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidAge() {
    new Customer(2, "Hermela", "Teklay", 0, "1234567890", 102);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidPhoneNumber() {
    new Customer(3, "Daniel", "Abebe", 25, "12345678", 103);
  }

  @Test
  public void testEqualsAndHashCode() {
    Customer customer1 = new Customer(4, "Hluf", "Green", 24, "0987654321", 104);
    Customer customer2 = new Customer(4, "Hluf", "Green", 24, "0987654321", 104);
    assertTrue(customer1.equals(customer2));
    assertEquals(customer1.hashCode(), customer2.hashCode());
  }
  @Test
  public void testToString() {
    Customer customer = new Customer(5, "Meron", "Embaye", 35, "1122334455", 105);
    String expected = "5,Meron,Embaye,35,1122334455,105";
    assertEquals(expected, customer.toString());
  }
}
