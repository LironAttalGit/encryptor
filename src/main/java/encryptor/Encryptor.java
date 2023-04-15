package encryptor;

import algorithms.*;
import algorithms.Double;
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
        String path = validator.verifyIfPathValid();
        File file = new File(path);

        switch (type) {
            case ENCRYPT -> {
                IAlgorithm caesar = new Caesar();
                IAlgorithm xor = new Xor();
                IAlgorithm multiplication = new Multiplication();

                IAlgorithm doubleEnc = new Double(caesar, multiplication);
                IAlgorithm reverse = new Reverse(doubleEnc);
                IAlgorithm doubleEnc1 = new Double(xor, reverse);
                System.out.println("encryption start");
                encryptToFile(file,doubleEnc1);
            }
            case DECRYPT -> {
                IAlgorithm caesar = new Caesar("caesar_key.bin");
                IAlgorithm xor = new Xor();
                IAlgorithm multiplication = new Multiplication();
                System.out.println("decryption start");
                decryptToFile(file, algorithm);
            }
            case QUIT -> System.out.println("Quiting");
        }
        userInput.closeScanner();
    }

    public void encryptToFile(File file, IAlgorithm algorithm) {
        try {
            File destFile = fileManager.createNewFile(file.getName().concat(".encrypted"), file.getParent());
            byte[] data = dataManipulation.encryptData(Files.readAllBytes(file.toPath()), algorithm);
            fileManager.writeDataToFile(destFile, data);
        } catch (IOException io) {
            System.out.println("There was a problem with the files");
        }
    }

    public void decryptToFile(File file, IAlgorithm algorithm) {
        try {
            File destFile = fileManager.createNewFile(file.getName().concat(".decrypted"), file.getParent());
            byte[] data = dataManipulation.decryptData(Files.readAllBytes(file.toPath()), algorithm);
            fileManager.writeDataToFile(destFile, data);
        } catch (IOException io) {
            System.out.println("There was a problem with the files");
        }
    }
}