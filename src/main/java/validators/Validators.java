package validators;

import algorithms.*;
import consts.Const.menuOptions;
import userInput.UserInput;

import java.nio.file.Files;
import java.nio.file.Path;

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
                inp = userInput.getStringInput();
                return verifyAction(inp);
            }
        }
    }

    public IAlgorithm verifyAlgorithm(String inp) {
        System.out.println("Choose an encryption algorithm\nEnter 1 for Caesar, 2 for Xor, 3 for Multiplication, 4 for Reverse");
        switch(inp) {
            case "1" -> {
                return new Caesar();
            }
            case "2" -> {
                return new Xor();
            }
            case "3" -> {
                return new Multiplication();
            }
            case "4" -> {
                return new Reverse(verifyAlgorithm(userInput.getStringInput()));
            }
            default -> {
                System.out.println("Enter 1 for Caesar, 2 for Xor, 3 for Multiplication,4 for Reverse");
                inp = userInput.getStringInput();
                return verifyAlgorithm(inp);
            }
        }
    }

    public String verifyIfPathValid() {
        System.out.println("Please enter the path:");
        String path = userInput.getStringInput();
        while(! isPathRight(path) || path.equals("\n")) {
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