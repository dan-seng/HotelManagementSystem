import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
public class FoodTest {
  private Food food;

  @Before
  public void setUp() {
    food = new Food();
  }

  @Test
  public void testMenuItemsLength() {
    String[] items = food.getMenuItems();
    assertEquals("Expected 10 menu items", 10, items.length);
  }

  @Test
  public void testGetPriceValidChoice() {
    assertEquals(75.0, food.getPrice(1), 0.001);
    assertEquals(310.0, food.getPrice(2), 0.001);
    assertEquals(200.0, food.getPrice(3), 0.001);
    //... you can add more if needed
    assertEquals(110.0, food.getPrice(10), 0.001);
  }
  @Test
  public void testGetPriceInvalidChoice() {
    // getPrice() should return 0.
    assertEquals(0.0, food.getPrice(0), 0.001); // Below valid range
    assertEquals(0.0, food.getPrice(11), 0.001); // Above valid range
  }
}
