package PasswordGenerator;

import java.util.Random;
import java.util.Scanner;

public class PasswordGenerator {
    private static final String CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()-_=+[]{}|;:,.<>?";
    private static Random random = new Random();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lengthOfThePassword;

        System.out.print("Enter password length (between 8 and 12): ");
        do {
            lengthOfThePassword = scanner.nextInt();

            if (!(lengthOfThePassword < 13) || !(lengthOfThePassword > 7)) {
                System.out.print("Password length must be between 8 and 12: ");
            }
        } while (!(lengthOfThePassword < 13) || !(lengthOfThePassword > 7));

        String password = generatePassword(lengthOfThePassword);

        System.out.println("Generated password: " + password);

        scanner.close();
    }

    public static String generatePassword(int length) {
        StringBuilder password = new StringBuilder();

        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(CHARS.length());
            password.append(CHARS.charAt(randomIndex));
        }

        return password.toString();
    }
}