import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class HotelTest {
    private Hotel hotel;

    @Before
    public void setUp() {
        // Initialize Hotel with 10 rooms before each test
        hotel = new Hotel(10);

    }

    @Test
    public void testBookRoom() {
        Customer customer = new Customer(1, "Hayle", "Abrha", 30, "1234567890", 101);
        hotel.bookRoom(customer);
        // Check if the room is now occupied
        assertTrue("Room should be occupied after booking.", hotel.rooms[0].isOccupied());
    }

    @Test
    public void testRemoveCustomer() {
        Customer customer = new Customer(2, "Alice", "Smith", 25, "0987654321", 102);
        hotel.bookRoom(customer);
        hotel.removeCustomer("Alice", "Smith");

        // Check if the room is now available again
        assertFalse("Room should be vacated after removing the customer.", hotel.rooms[1].isOccupied());
    }

    @Test
    public void testAddEmployee() {
        Employee employee = new Employee("Mike", "Johnson", "Male", 40, "Manager", 50000);
        hotel.addEmployee(employee);
        assertEquals("Employee count should increase after adding.", 1, hotel.getEmployeeCount());
    }

}
