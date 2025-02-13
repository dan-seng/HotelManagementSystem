/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author cx
 */
import java.io.*;
import java.util.*;

public class FileManager {

    // Using try-with-resources for proper resource management
    public static String[] readFile(String fileName) {
        List<String> dataList = new ArrayList<>();
        File file = new File(fileName);
        if (file.exists()) {
            try (Scanner scanner = new Scanner(file)) {
                while (scanner.hasNextLine()) {
                    dataList.add(scanner.nextLine());
                }
            } catch (IOException e) {
                System.out.println("Error reading the file: " + e.getMessage());
            }
        }
        return dataList.toArray(new String[0]);
    }

    // Validate data and use try-with-resources. Overwrite file when append = false.
    public static void writeFile(String fileName, String[] data, boolean append) {
        if (data == null || data.length == 0) {
            System.out.println("No data to write.");
            return;
        }
        try (BufferedWriter buffer = new BufferedWriter(new FileWriter(fileName, append))) {
            for (String line : data) {
                buffer.write(line);
                buffer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error writing to the file: " + e.getMessage());
        }
    }
}
