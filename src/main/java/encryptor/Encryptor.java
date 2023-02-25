package encryptor;

import consts.Const;
import dataManipulation.DataManipulation;
import fileManager.FileManager;
import userInput.UserInput;
import validators.Validators;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;

import static consts.Const.options;

public class Encryptor {
    UserInput userInput = new UserInput();
    FileManager fileManager = new FileManager();

    DataManipulation dataManipulation = new DataManipulation();

    public void start() {
        System.out.println("starting encryptor");
        Validators validator = new Validators();
        String type = validator.verifyAction();
        if(! type.equals(options.get("QUIT"))) {
            String path = validator.verifyIfPathValid();
            File file = new File(path);
            switch(options.get(type)) {
                case "ENCRYPT" -> encryptToFile(file);
                case "DECRYPT" -> decryptToFile(file);
            }
        } else {
            System.out.println("Quiting");
        }
        userInput.closeScanner();
    }

    public void encryptToFile(File file) {
        try {
            File destFile = fileManager.createNewFile(file.getName().concat(".encrypted") , file.getParent());
            byte[] data = dataManipulation.getEncData(Files.readAllBytes(file.toPath()));
            fileManager.writeDataToFile(destFile , data);
        } catch(IOException io) {
            System.out.println("There was a problem with the files");
        }
    }

    public void decryptToFile(File file) {
        try {
            File destFile = fileManager.createNewFile(file.getName().concat(".decrypted") , file.getParent());
            InputStream inputStream = new FileInputStream(file);
            byte[] data = dataManipulation.getDecData(inputStream.readAllBytes());
            fileManager.writeDataToFile(destFile , data);
            inputStream.close();
        } catch(IOException io) {
            System.out.println("There was a problem with the files");
        }
    }
}