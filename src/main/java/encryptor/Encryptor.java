package encryptor;

import fileManager.FileManager;
import userInput.UserInput;
import validators.Validators;

import java.io.File;

import static consts.Const.*;

public class Encryptor {
    UserInput userInput = new UserInput();

    public void start() {
        System.out.println("starting encryptor");
        Validators validator = new Validators();
        String type = validator.verifyAction();
        if(! type.equals(QUIT)) {
            FileManager fileManager = new FileManager();
            String path = validator.verifyIfPathValid();
            File file = new File(path);
            switch(type) {
                case ENCRYPT -> fileManager.encryptToFile(file);
                case DECRYPT -> fileManager.decryptToFile(file);
            }
        } else {
            System.out.println("Quiting");
        }
        userInput.closeScanner();
    }
}
