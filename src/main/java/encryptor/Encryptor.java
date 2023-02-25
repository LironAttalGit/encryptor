package encryptor;

import fileManager.FileManager;
import userInput.UserInput;
import validators.Validators;

import java.io.File;
import java.io.IOException;

import static consts.Const.*;

public class Encryptor {

    UserInput userInput = new UserInput();

    public void start() throws IOException {
        System.out.println("starting encryptor");

        Validators validator = new Validators();
        String type = validator.verifyAction();

        FileManager fileManager = new FileManager();
        String path = validator.verifyIfPathValid();

        File file = new File(path);
        switch(type) {
            case ENCRYPT -> fileManager.encryptToFile(file);
            case DECRYPT -> fileManager.decryptToFile(file);
            case QUIT -> System.out.println("Quiting");
        }
        userInput.closeScanner();
    }
}
