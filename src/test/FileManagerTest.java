import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.*;

public class FileManagerTest {
    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    @Test
    public void testReadFileWhenFileDoesNotExist() {
        String filePath = folder.getRoot().getAbsolutePath() + "/nonexistent.txt";
        assertArrayEquals(new String[]{}, FileManager.readFile(filePath));
    }

    @Test
    public void testWriteAndReadFile() throws IOException {
        File file = folder.newFile("testfile.txt");
        String[] data = { "Line 1", "Line 2", "Line 3" };
        
        FileManager.writeFile(file.getAbsolutePath(), data, false);
        assertArrayEquals(data, FileManager.readFile(file.getAbsolutePath()));
    }

    @Test
    public void testWriteFileAppend() throws IOException {
        File file = folder.newFile("appendtest.txt");
        FileManager.writeFile(file.getAbsolutePath(), new String[]{"Initial"}, false);
        FileManager.writeFile(file.getAbsolutePath(), new String[]{"Appended"}, true);

        assertArrayEquals(new String[]{"Initial", "Appended"}, FileManager.readFile(file.getAbsolutePath()));
    }

    @Test
    public void testWriteFileWithEmptyOrNullData() throws IOException {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        File file = folder.newFile("emptyDataTest.txt");
        FileManager.writeFile(file.getAbsolutePath(), new String[]{}, false);
        FileManager.writeFile(file.getAbsolutePath(), null, false);

        System.setOut(null);
        assertTrue(output.toString().contains("No data to write."));
    }
}
