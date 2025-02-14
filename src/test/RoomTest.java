import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class RoomTest {

  private Room room;

  @Before
  public void setup() {
    room = new Room(101, "Single", 100.0);
  }
  @Test
  public void testGetRoomNumber() {
    assertEquals(101, room.getRoomNumber());
  }
  @Test
  public void testGetRoomType() {
    assertEquals("Single", room.getRoomType());
  }
  @Test
  public void testGetRoomPrice() {
    assertEquals(100.0, room.getRoomPrice(), 0.01);
  }
  @Test
  public void testIsOccupiedInitially() {
    assertFalse(room.isOccupied());
  }
  @Test
  public void testOccupyRoom() {
    room.occupyRoom();
    assertTrue(room.isOccupied());
  }
  @Test
  public void testVacateRoom() {
    room.occupyRoom();
    room.vacateRoom();
    assertFalse(room.isOccupied());
  }
  @Test
  public void testToString() {
    // Initially, room should be unoccupied
    String expectedString = "101,Single,100.0,No";
    assertEquals(expectedString, room.toString());
    // After occupying the room
    room.occupyRoom();
    expectedString = "101,Single,100.0,Yes";
    assertEquals(expectedString, room.toString());
  }

  // Test case for unimplemented method 'isAvailable'
  @Test(expected = UnsupportedOperationException.class)
  public void testIsAvailable() {
    room.isAvailable(); // This method should throw an exception
  }

  // Test case for unimplemented method 'updateRoomPrice'
  @Test(expected = UnsupportedOperationException.class)
  public void testUpdateRoomPrice() {
    room.updateRoomPrice(120.0); // This method should throw an exception
  }
}
