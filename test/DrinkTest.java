import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class DrinkTest {
    private Drink drink;

    @Before
    public void setUp() {
        // Initialize the Drink object before each test.
        drink = new Drink();
    }

    @Test
    public void testMenuItemsLength() {
        // Verify that the menuItems array contains 10 items.
        assertEquals("Expected 10 menu items", 10, drink.getMenuItems().length);
    }

    @Test
    public void testGetPriceValidChoice() {
        // Check that valid menu choices return the correct price.
        assertEquals(5.0, drink.getPrice(1), 0.001); // Tea
        assertEquals(10.0, drink.getPrice(2), 0.001); // Coffee
        assertEquals(25.0, drink.getPrice(3), 0.001); // Milk
        // ... you can add more if needed
        assertEquals(2500.0, drink.getPrice(10), 0.001); // Whiskey
    }

    @Test
    public void testGetPriceInvalidChoice() {
        // For invalid menu choices (less than 1 or greater than available items),
        // getPrice() should return 0.
        assertEquals(0.0, drink.getPrice(0), 0.001); // Below valid range
        assertEquals(0.0, drink.getPrice(11), 0.001); // Above valid range
    }

    // Note: Testing showMenu() is optional as it prints to the console.
    // If needed, you could capture System.out and verify the output.
}
