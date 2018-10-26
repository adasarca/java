/**
 * Created by Ada.Sarca
 * Date: 10/26/2018
 */
package io;

import java.util.Scanner;

public class ScannerExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Insert an integer X: ");
        int x = scanner.nextInt();
        System.out.println("X = " + x);
    }
}
