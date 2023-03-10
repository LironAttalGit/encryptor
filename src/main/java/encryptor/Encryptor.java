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
        menuOptions type = validator.verifyAction();
        IAlgorithm algorithm = validator.verifyAlgorithm(userInput.getStringInput());
        String path = validator.verifyIfPathValid();
        File file = new File(path);
        switch(type) {
            case ENCRYPT -> {
                byte[] key = algorithm.generateRandomEncryptKey();
                System.out.println("encryption start");
                encryptToFile(file , algorithm , key);
            }
            case DECRYPT -> {
                byte[] key = userInput.keyInput();
                System.out.println("decryption start");
                decryptToFile(file , algorithm , key);
            }
            case QUIT -> System.out.println("Quiting");
        }
        userInput.closeScanner();
    }

    public void encryptToFile(File file , IAlgorithm algorithm , byte[] key) {
        try {
            File destFile = fileManager.createNewFile(file.getName().concat(".encrypted") , file.getParent());
            byte[] data = dataManipulation.encryptData(Files.readAllBytes(file.toPath()) , algorithm , key);
            fileManager.writeDataToFile(destFile , data);
        } catch(IOException io) {
            System.out.println("There was a problem with the files");
        }
    }

    public void decryptToFile(File file , IAlgorithm algorithm , byte[] key) {
        try {
            File destFile = fileManager.createNewFile(file.getName().concat(".decrypted") , file.getParent());
            byte[] data = dataManipulation.decryptData(Files.readAllBytes(file.toPath()) , algorithm , key);
            fileManager.writeDataToFile(destFile , data);
        } catch(IOException io) {
            System.out.println("There was a problem with the files");
        }
    }
}