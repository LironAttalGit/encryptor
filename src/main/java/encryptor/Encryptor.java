package encryptor;

import algorithms.Caesar;
import algorithms.IAlgorithm;
import algorithms.Xor;
import consts.Const.menuOptions;
import dataManipulation.DataManipulation;
import fileManager.FileManager;
import userInput.UserInput;
import validators.Validators;

import java.io.File;

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
        IAlgorithm[] algorithms = new IAlgorithm[2];
        algorithms[0] = new Caesar();
        algorithms[1] = new Xor();
        switch(type) {
            case ENCRYPT -> {

                File keyBin = fileManager.createNewFile("key.bin" , "G:\\encryptor\\Files");

//                IAlgorithm caesar = new Caesar();
//                IAlgorithm xor = new Xor();
//                IAlgorithm multiplication = new Multiplication();
//                IAlgorithm doubleEnc = new Double(caesar, multiplication);
//                IAlgorithm reverse = new Reverse(doubleEnc);
//                IAlgorithm doubleEnc1 = new Double(xor, reverse);
                System.out.println("encryption start");
                for(int i = 0; i< algorithms.length;i++)
                    algorithms[i].generateRandomEncryptKey(keyBin);
//                caesar.generateRandomEncryptKey(keyBin);
//                xor.generateRandomEncryptKey(keyBin);

                encryptToFile(file , fileManager.readDataFromFile(keyBin) , algorithms);
//               encryptToFile(file,doubleEnc1);
            }
            case DECRYPT -> {
//                IAlgorithm caesar = new Caesar();
                byte[] keyBin = fileManager.readDataFromFile(new File("G:\\encryptor\\Files\\key.bin"));
                System.out.println("decryption start");
                decryptToFile(file , keyBin ,algorithms );
//                IAlgorithm caesar = new Caesar();
//                IAlgorithm xor = new Xor();
//                IAlgorithm multiplication = new Multiplication();
//                System.out.println("decryption start");
//                decryptToFile(file, algorithm);
            }
            case QUIT -> System.out.println("Quiting");
        }
        userInput.closeScanner();
    }

    public void encryptToFile(File file , byte[] key , IAlgorithm[] algorithm) {
        try {
            File destFile = fileManager.createNewFile(file.getName().concat(".encrypted") , file.getParent());
            byte[] data = dataManipulation.encryptData(fileManager.readDataFromFile(file) , key , algorithm);
            fileManager.writeDataToFile(destFile , data);
        } catch(Exception e) {
            System.out.println("There was a problem with file");
        }
    }

    public void decryptToFile(File file , byte[] key , IAlgorithm[] algorithm) {
        try {
            File destFile = fileManager.createNewFile(file.getName().concat(".decrypted") , file.getParent());
            byte[] data = dataManipulation.decryptData(fileManager.readDataFromFile(file) , key , algorithm);
            fileManager.writeDataToFile(destFile , data);
        } catch(Exception e) {
            System.out.println("There was a problem with the files");
        }
    }
}