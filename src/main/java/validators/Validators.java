package validators;

import userInput.UserInput;

import java.nio.file.Files;
import java.nio.file.Path;

import static consts.Const.DECRYPT;
import static consts.Const.ENCRYPT;

public class Validators {
    UserInput userInput = new UserInput();

    public int verifyAction() {
        System.out.println("Please choose 1 for encrypt or  2 for decrypt");
        int type = userInput.getIntInput();
        while(type != ENCRYPT && type != DECRYPT) {
            System.out.println("Please choose 1 for encrypt or  2 for decrypt");
            type = userInput.getIntInput();
        }
        return type;
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
