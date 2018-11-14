/**
 * Created by Ada.Sarca
 * Date: 11/14/2018
 */
package io;

import java.io.*;

public class BufferedWriterExample {

    public static void main(String[] args) {
        writeToFile();
        writeToConsole();
    }

    private static void writeToFile() {
        System.out.println("Writing to file...");

        String filePath = "src/main/resources/output.txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            String text = "Hello!\nHow are you?\nI'm super!\nKiss\n";
            writer.write(text);
            System.out.println("Successfully printed:\n" + text);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writeToConsole() {
        System.out.println("Writing to console...");

        try (BufferedWriter writer = new BufferedWriter(new PrintWriter(System.out))) {
            String text = "Hello!\nHow are you?\nI'm super!\nKiss\n";
            writer.write(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
