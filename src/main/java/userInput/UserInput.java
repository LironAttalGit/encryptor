package userInput;

import java.util.Scanner;

public class UserInput {
    Scanner scanner = new Scanner(System.in);

    public Scanner getScanner() {
        return new Scanner(System.in);
    }

    public byte[] getByteInput() {
        byte[] userByteInput = new byte[1];
        userByteInput[0] = scanner.nextByte();
        return userByteInput;
    }

    public String getStringInput() {
        return scanner.nextLine();
    }

    public byte[] keyInput() {
        System.out.println("Enter the decryption key: ");
        return getByteInput();
    }

    public void closeScanner() {
        scanner.close();
    }
}