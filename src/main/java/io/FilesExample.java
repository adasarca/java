/**
 * Created by Ada.Sarca
 * Date: 10/26/2018
 */
package io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FilesExample {

    public static void main(String[] args) {
        //read
        System.out.println("Reading with Files...");
        Path inputPath = Paths.get("src/main/resources/input.txt");
        try {
            List<String> lines = Files.readAllLines(inputPath);
            for (String line : lines) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println();

        //write
        System.out.println("Writing with Files...");
        Path outputPath = Paths.get("src/main/resources/output.txt");

        String text = "Hello!\nHow are you?\n";
        byte[] bytes = text.getBytes();

        try {
            Files.write(outputPath, bytes);
            System.out.println("Successfully printed:\n" + text);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
