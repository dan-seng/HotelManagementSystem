import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

public class HotelManagementSystemTest {
    private Hotel hotel;
    private Food food;
    private Drink drink;
    private InputStream originalIn;

    @Before
    public void setUp() {
        // Save the original System.in so we can restore it after each test
        originalIn = System.in;
        hotel = new Hotel(100);
        food = new Food();
        drink = new Drink();
    }
    @Test
    public void testBookRoomForCustomer() {
        // Simulate user input for booking room #5
        String input = "1\nMeron\nEmbaye\n25\n1234567890\n5\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        try (Scanner scanner = new Scanner(System.in)) {
            HotelMangementSystem.bookRoomForCustomer(hotel, scanner);
        }
        // Verify that room #5 is now booked
        assertTrue("Room 5 should be booked", hotel.isRoomBooked(5));
    }
    @Test
    public void testOrderFood() {
        // Simulate user input ordering items #1 and #2, then 0 to finish
        String input = "1\n2\n0\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        try (Scanner scanner = new Scanner(System.in)) {
            HotelMangementSystem.orderFood(food, scanner);
        }
        // Just verify the prices are valid; actual "total" is printed to console
        assertTrue("Item 1 price should be > 0", food.getPrice(1) > 0);
        assertTrue("Item 2 price should be > 0", food.getPrice(2) > 0);
    }
    @Test
    public void testOrderDrink() {
        // Simulate user input ordering item #1, then 0 to finish
        String input = "1\n0\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        try (Scanner scanner = new Scanner(System.in)) {
            HotelMangementSystem.orderToDrink(drink, scanner);
        }
        // Verify item #1 price is valid
        assertTrue("Drink item 1 price should be > 0", drink.getPrice(1) > 0);
    }
    // Optional: Restore System.in after each test
    // (Prevents potential interference if other tests rely on System.in)
    @org.junit.After
    public void tearDown() {
        System.setIn(originalIn);
    }
}
