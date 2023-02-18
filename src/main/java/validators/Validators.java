package validators;

import userInput.UserInput;

import java.nio.file.Files;
import java.nio.file.Path;

import static consts.Const.*;

public class Validators {
    UserInput userInput = new UserInput();

    public String verifyAction() {
        System.out.println("Please enter 1 for encrypt or 2 for decrypt or 3 for quit");
        String inp = userInput.getScanner().nextLine();
        while(! inp.equals("") || userInput.getScanner().hasNextLine()) {
            if(inp.equals(ENCRYPT) || inp.equals(DECRYPT) || inp.equals(QUIT)) {
                break;
            }
            System.out.println("Please enter 1 for encrypt or 2 for decrypt or 3 for quit");
            inp = userInput.getScanner().nextLine();
        }
        return inp;
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