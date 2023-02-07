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

    public int getIntInput() {
        int input = scanner.nextInt();
        scanner.nextLine();
        return input;
    }

    public void closeScanner() {
        scanner.close();
    }
}
