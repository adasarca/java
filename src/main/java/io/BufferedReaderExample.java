/**
 * Created by Ada.Sarca
 * Date: 11/14/2018
 */
package io;

import java.io.*;

public class BufferedReaderExample {

    public static void main(String[] args) {
        readFromFile();
        readFromConsole();
    }

    private static void readFromFile() {
        System.out.println("Reading from file...");

        String filePath = "src/main/resources/input.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void readFromConsole() {
        System.out.println("Reading from console...");

        System.out.println("Insert 5 lines:");
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder stringBuilder = new StringBuilder();
            int count = 0;
            String line;
            while (count++ < 5 && (line = reader.readLine()) != null) {
                stringBuilder.append(line).append("\n");
            }
            System.out.println("Result:\n" + stringBuilder.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
