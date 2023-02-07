package run;

import fileManager.FileManager;
import userInput.UserInput;
import validators.Validators;

import java.io.File;
import java.io.IOException;

import static consts.Const.DECRYPT;
import static consts.Const.ENCRYPT;

public class Run {

    UserInput userInput = new UserInput();

    public void start() throws IOException {
        Validators validator = new Validators();
        FileManager fileManager = new FileManager();

        int type = validator.verifyAction();
        String path = validator.verifyIfPathValid();

        File file = new File(path);
        switch(type) {
            case ENCRYPT -> fileManager.encryptToFile(file);
            case DECRYPT -> fileManager.decryptToFile(file);
        }
        userInput.closeScanner();
    }
}
