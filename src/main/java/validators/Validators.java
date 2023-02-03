package validators;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class Validators {
    public String verifyIfEncryptOrDecrypt(Scanner scanner) {
        System.out.println("Please choose 1 for encrypt or  2 for decrypt:");
        String type = scanner.nextLine();
        do {
            if(type.equals("1") || type.equals("2")) {
                break;
            }
            System.out.println("Please choose 1 for encrypt or  2 for decrypt");
            type = scanner.nextLine();
        } while(! type.equals("1") || ! type.equals("2"));
        return type;
    }

    public String verifyIfPathValid(Scanner scanner) {
        System.out.println("Please enter the path:");
        String path = scanner.next();
        do {
            if(isPathRight(path)) {
                System.out.println("The path is valid");
                break;
            }
            System.out.println("error, path is not valid, enter path again:");
            path = scanner.next();
        } while(! isPathRight(path));
        return path;
    }

    public boolean isPathRight(String path) {
        Path path1 = Path.of(path);
        return Files.exists(path1) && ! Files.isDirectory(path1);
    }
}
