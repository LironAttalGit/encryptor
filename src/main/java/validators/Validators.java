package validators;

import consts.Const.options;

import userInput.UserInput;

import java.nio.file.Files;
import java.nio.file.Path;

import static consts.Const.options.*;


public class Validators {
    UserInput userInput = new UserInput();

    public options verifyAction(String inp) {
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