package validators;

import consts.Const.menuOptions;
import userInput.UserInput;

import java.nio.file.Files;
import java.nio.file.Path;

import static consts.Const.encryptionOptions;
import static consts.Const.encryptionOptions.*;
import static consts.Const.menuOptions.*;


public class Validators {
    UserInput userInput = new UserInput();

    public menuOptions verifyAction(String inp) {

        switch(inp) {
            case "1" -> {
                return ENCRYPT;
            }
            case "2" -> {
                return DECRYPT;
            }
            case "3" -> {
                return QUIT;
            }
            default -> {
                System.out.println("Enter 1 for Encrypt, 2 for Decrypt, 3 for Quit");
                inp = userInput.getScanner().nextLine();
                return verifyAction(inp);
            }
        }
    }

    public encryptionOptions verifyEncryptDecryptAlgorithm(String inp) {
        switch(inp) {
            case "1" -> {
                return CAESAR;
            }
            case "2" -> {
                return XOR;
            }
            case "3" -> {
                return MULTIPLICATION;
            }
            case "4" -> {
                return REVERSE;
            }
            default -> {
                System.out.println("Enter 1 for Caesar, 2 for Xor, 3 for Reverse");
                inp = userInput.getScanner().nextLine();
                return verifyEncryptDecryptAlgorithm(inp);
            }
        }
    }

    public encryptionOptions verifyReverseTypeAlgorithm(String inp) {
        switch(inp) {
            case "1" -> {
                return CAESAR;
            }
            case "2" -> {
                return XOR;
            }
            default -> {
                System.out.println("Enter 1 for Caesar, 2 for Xor, 3 for Reverse");
                inp = userInput.getScanner().nextLine();
                return verifyEncryptDecryptAlgorithm(inp);

            }
        }
    }

    public String verifyIfPathValid() {
        System.out.println("Please enter the path:");
        String path = userInput.getStringInput();
        while(! isPathRight(path)) {
            System.out.println("error, path is not valid, enter path again:");
            path = userInput.getStringInput();
        }
        return path;
    }

    public boolean isPathRight(String path) {
        Path path1 = Path.of(path);
        return Files.exists(path1) && ! Files.isDirectory(path1);
    }
}