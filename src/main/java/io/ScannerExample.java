/**
 * Created by Ada.Sarca
 * Date: 10/26/2018
 */
package io;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ScannerExample {

    public static void main(String[] args) {
        readFromConsole();
        readFromFile();
    }

    private static void readFromConsole() {
        System.out.println("Reading from console...");
        Scanner scanner = new Scanner(System.in);

        System.out.print("Insert an integer X: ");
        int x = scanner.nextInt();
        System.out.println("X = " + x);

        System.out.print("Insert a double Y: ");
        double y = scanner.nextDouble();
        System.out.println("Y = " + y);

        System.out.print("Insert a word: ");
        String word = scanner.next();
        scanner.nextLine(); //read end of line character
        System.out.println("Word: " + word);

        System.out.print("Insert multiple words: ");
        String line = scanner.nextLine();
        System.out.println("Line: " + line);

        scanner.close();
        System.out.println();
    }

    private static void readFromFile() {
        System.out.println("Reading from file...");
        File file = new File("src/main/resources/input.txt");
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()) {
                System.out.println(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
