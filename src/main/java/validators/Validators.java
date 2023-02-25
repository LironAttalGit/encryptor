package validators;

import userInput.UserInput;

import java.nio.file.Files;
import java.nio.file.Path;

import static consts.Const.options;

public class Validators {
    UserInput userInput = new UserInput();

    public String verifyAction() {
        String inp;
        do {
            options.forEach((key , value) ->
                    System.out.printf("Enter %s for %s\n" , value , key));
            inp = userInput.getScanner().nextLine();
        } while(! (options.containsKey(inp)));
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