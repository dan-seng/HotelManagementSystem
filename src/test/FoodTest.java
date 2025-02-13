import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class FoodTest {
  private Food food;

  @Before
  public void setUp() {
    // Initialize the Food object before each test
    food = new Food();
  }

  @Test
  public void testMenuItemsLength() {
    // Verify that the menuItems array contains 10 items
    String[] items = food.getMenuItems();
    assertEquals("Expected 10 menu items", 10, items.length);
  }

  @Test
  public void testGetPriceValidChoice() {
    // Test valid menu choices and verify that the correct prices are returned.
    // For example, the first item ("Shiro") should cost 75.0,
    // the second ("Thibsi") should cost 310.0, etc.
    assertEquals(75.0, food.getPrice(1), 0.001);
    assertEquals(310.0, food.getPrice(2), 0.001);
    assertEquals(200.0, food.getPrice(3), 0.001);
    // Check the last item ("BeyeAynet")
    assertEquals(110.0, food.getPrice(10), 0.001);
  }

  @Test
  public void testGetPriceInvalidChoice() {
    // Test for invalid menu choices.
    // When the choice is less than 1 or greater than the number of items,
    // getPrice should return 0.
    assertEquals(0.0, food.getPrice(0), 0.001); // Below valid range
    assertEquals(0.0, food.getPrice(11), 0.001); // Above valid range
  }
}
