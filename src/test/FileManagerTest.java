import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.io.IOException;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class FileManagerTest {

  // TemporaryFolder rule creates temporary files and directories for testing.
  @Rule
  public TemporaryFolder folder = new TemporaryFolder();

  @Test
  public void testReadFileWhenFileDoesNotExist() {
    // Create a filename that does not exist.
    String nonExistentFileName = folder.getRoot().getAbsolutePath() + "/nonexistent.txt";
    String[] result = FileManager.readFile(nonExistentFileName);
    assertNotNull("Result should not be null", result);
    assertEquals("Expected an empty array for a non-existent file", 0, result.length);
  }

  @Test
  public void testWriteAndReadFile() throws IOException {
    // Create a temporary file.
    File tempFile = folder.newFile("testfile.txt");
    String fileName = tempFile.getAbsolutePath();
    String[] dataToWrite = { "Line 1", "Line 2", "Line 3" };

    // Write data (overwrite mode)
    FileManager.writeFile(fileName, dataToWrite, false);

    // Read the file and verify the content.
    String[] dataRead = FileManager.readFile(fileName);
    assertArrayEquals("The data read should match the data written.", dataToWrite, dataRead);
  }

  @Test
  public void testWriteFileAppend() throws IOException {
    // Create a temporary file.
    File tempFile = folder.newFile("appendtest.txt");
    String fileName = tempFile.getAbsolutePath();

    String[] initialData = { "Initial line" };
    String[] appendedData = { "Appended line" };

    // Write initial data (overwrite mode)
    FileManager.writeFile(fileName, initialData, false);
    // Append additional data.
    FileManager.writeFile(fileName, appendedData, true);

    // Read file and verify that both sets of lines exist in order.
    String[] dataRead = FileManager.readFile(fileName);
    String[] expected = { "Initial line", "Appended line" };
    assertArrayEquals("File content should contain the initial data followed by appended data.", expected, dataRead);
  }

  @Test
  public void testWriteFileWithEmptyData() throws IOException {
    // Capture the standard output.
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    PrintStream originalOut = System.out;
    System.setOut(new PrintStream(baos));

    // Create a temporary file.
    File tempFile = folder.newFile("emptyDataTest.txt");
    String fileName = tempFile.getAbsolutePath();

    // Call writeFile() with an empty array.
    FileManager.writeFile(fileName, new String[] {}, false);

    // Restore standard output.
    System.setOut(originalOut);
    String output = baos.toString();
    assertTrue("Expected output to contain 'No data to write.'", output.contains("No data to write."));
  }

  @Test
  public void testWriteFileWithNullData() throws IOException {
    // Capture the standard output.
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    PrintStream originalOut = System.out;
    System.setOut(new PrintStream(baos));

    // Create a temporary file.
    File tempFile = folder.newFile("nullDataTest.txt");
    String fileName = tempFile.getAbsolutePath();

    // Call writeFile() with null data.
    FileManager.writeFile(fileName, null, false);

    // Restore standard output.
    System.setOut(originalOut);
    String output = baos.toString();
    assertTrue("Expected output to contain 'No data to write.'", output.contains("No data to write."));
  }
}
