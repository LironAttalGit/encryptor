package dataManipulation;

import algorithms.IAlgorithm;
import userInput.UserInput;
import validators.Validators;

import java.util.Random;

public class DataManipulation {
    UserInput userInput = new UserInput();

    Validators validator = new Validators();

    public byte[] generateRandomEncryptKey() {
        Random rand = new Random();
        byte[] key = new byte[1];
        rand.nextBytes(key);
        System.out.format("The key is : %d\n" , key[0]);
        return key;
    }

    public byte[] getEncData(byte[] data) {
        IAlgorithm algo = validator.verifyAlgorithm(userInput.getStringInput());
        byte[] key = generateRandomEncryptKey();
        byte[] encData = new byte[data.length];
        for(int i = 0 ; i < data.length ; i++) {
            encData[i] = algo.encrypt(data[i] , key[0]);
        }
        return encData;
    }

    public byte[] getDecData(byte[] data) {
        IAlgorithm algo = validator.verifyAlgorithm(userInput.getStringInput());
        byte[] key = userInput.keyInput();
        byte[] decData = new byte[data.length];
        for(int i = 0 ; i < data.length ; i++) {
            decData[i] = algo.decrypt(data[i] , key[0]);
        }
        return decData;
    }
}