package encryptor;

import algorithms.IAlgorithm;
import consts.Const.menuOptions;
import dataManipulation.DataManipulation;
import fileManager.FileManager;
import userInput.UserInput;
import validators.Validators;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class Encryptor {
    UserInput userInput = new UserInput();
    FileManager fileManager = new FileManager();
    DataManipulation dataManipulation = new DataManipulation();
    Validators validator = new Validators();

    public void start() {
        System.out.println("starting encryptor");
        System.out.println("Enter 1 for Encrypt, 2 for Decrypt, 3 for Quit");
        menuOptions type = validator.verifyAction(userInput.getStringInput());
        String path = validator.verifyIfPathValid();
        File file = new File(path);
        switch(type) {
            case ENCRYPT -> {
                System.out.println("encryption start");
                encryptToFile(file);
            }
            case DECRYPT -> {
                System.out.println("decryption start");
                decryptToFile(file);
            }
            case QUIT -> System.out.println("Quiting");
        }
        userInput.closeScanner();
    }

    public void encryptToFile(File file) {
        try {
            File destFile = fileManager.createNewFile(file.getName().concat(".encrypted") , file.getParent());
            IAlgorithm algorithm = validator.verifyAlgorithm(userInput.getStringInput());
            byte[] key = dataManipulation.generateRandomEncryptKey();
            byte[] data = dataManipulation.getEncData(Files.readAllBytes(file.toPath()) , algorithm , key);
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
            IAlgorithm algorithm = validator.verifyAlgorithm(userInput.getStringInput());
            byte[] key = userInput.keyInput();
            byte[] data = dataManipulation.getDecData(Files.readAllBytes(file.toPath()) , algorithm , key);
            fileManager.writeDataToFile(destFile , data);
        } catch(IOException io) {
            System.out.println("There was a problem with the files");
        }
    }
}