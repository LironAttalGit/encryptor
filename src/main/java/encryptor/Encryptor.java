package encryptor;

import consts.Const.menuOptions;
import dataManipulation.DataManipulation;
import fileManager.FileManager;
import userInput.UserInput;
import validators.Validators;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;

public class Encryptor {
    UserInput userInput = new UserInput();
    FileManager fileManager = new FileManager();

    DataManipulation dataManipulation = new DataManipulation();

    Validators validator = new Validators();

    public void start() {
        System.out.println("starting encryptor");
        System.out.println("Enter 1 for Encrypt, 2 for Decrypt, 3 for Quit");
        menuOptions type = validator.verifyAction(userInput.getScanner().nextLine());
        switch(type) {
            case ENCRYPT -> {
                System.out.println("encryption start");
                String path = validator.verifyIfPathValid();
                File file = new File(path);
                encryptToFile(file);
            }
            case DECRYPT -> {
                System.out.println("decryption start");
                String path = validator.verifyIfPathValid();
                File file = new File(path);
                decryptToFile(file);
            }
            case QUIT -> System.out.println("Quiting");
        }
        userInput.closeScanner();
    }

    public void encryptToFile(File file) {
        try {
            File destFile = fileManager.createNewFile(file.getName().concat(".encrypted") , file.getParent());
            System.out.println("Choose an encryption algorithm.");
            System.out.println("Enter 1 for Caesar, 2 for Xor, 3 for Multiplication, 4 for Reverse");
            byte[] data = dataManipulation.getEncData(Files.readAllBytes(file.toPath()));
            fileManager.writeDataToFile(destFile , data);
        } catch(IOException io) {
            System.out.println("There was a problem with the files");
        }
    }

    public void decryptToFile(File file) {
        try {
            File destFile = fileManager.createNewFile(file.getName().concat(".decrypted") , file.getParent());
            System.out.println("Choose an decryption algorithm.");
            System.out.println("Enter 1 for Caesar, 2 for Xor, 3 for Multiplication, 4 for Reverse");
            InputStream inputStream = new FileInputStream(file);
            byte[] data = dataManipulation.getDecData(inputStream.readAllBytes());
            fileManager.writeDataToFile(destFile , data);
            inputStream.close();
        } catch(IOException io) {
            System.out.println("There was a problem with the files");
        }
    }
}

