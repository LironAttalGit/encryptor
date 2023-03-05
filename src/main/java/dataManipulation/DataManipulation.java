package dataManipulation;

import consts.Const.encryptionOptions;
import userInput.UserInput;
import validators.Validators;

import java.util.Random;

public class DataManipulation {
    UserInput userInput = new UserInput();

    Validators validator = new Validators();

    public byte caesarEncryptSingleByte(byte b , byte key) {
        return (byte) (b + key);
    }

    public byte caesarDecryptSingleByte(byte b , byte key) {
        return (byte) (b - key);
    }

    public byte xorEncryptDecryptSingleByte(byte b , byte key) {
        return (byte) (b ^ key);
    }

    public byte multiplyingSingleByteWithKey(byte b , byte key) {
        return (byte) (b * key);
    }

    public byte[] generateRandomEncryptKey() {
        Random rand = new Random();
        byte[] key = new byte[1];
        rand.nextBytes(key);
        System.out.format("The key is : %d\n" , key[0]);
        return key;
    }

    public byte[] encryptCaesarData(byte[] data , byte[] key) {
        byte[] encData = new byte[data.length];
        for(int i = 0 ; i < data.length ; i++) {
            encData[i] = caesarEncryptSingleByte(data[i] , key[0]);
        }
        return encData;
    }

    public byte[] decryptCaesarData(byte[] data , byte[] key) {
        byte[] decData = new byte[data.length];
        for(int i = 0 ; i < data.length ; i++) {
            decData[i] = caesarDecryptSingleByte(data[i] , key[0]);
        }
        return decData;
    }

    public byte[] XorData(byte[] data , byte[] key) {
        byte[] encData = new byte[data.length];
        for(int i = 0 ; i < data.length ; i++) {
            encData[i] = xorEncryptDecryptSingleByte(data[i] , key[0]);
        }
        return encData;
    }

    public byte[] encryptMultiplyingData(byte[] data , byte[] key) {
        if(key[0] == 0 || key[0] % 2 == 0) {
            return data;
        }
        byte[] encData = new byte[data.length];
        for(int i = 0 ; i < data.length ; i++) {
            encData[i] = multiplyingSingleByteWithKey(data[i] , key[0]);
        }
        return encData;
    }

    public byte[] decryptMultiplyingData(byte[] data , byte[] key) {
        byte[] decData = new byte[data.length];
        byte mwo = decKey(key[0]);
        for(int i = 0 ; i < data.length ; i++) {
            decData[i] = multiplyingSingleByteWithKey(data[i] , mwo);
        }
        return decData;
    }

    public byte decKey(byte key) {
        for(byte i = Byte.MIN_VALUE ; i < Byte.MAX_VALUE ; i++) {
            if((byte) (i * key) == (byte) (1)) {
                return i;
            }
        }
        return 0;
    }

    public byte[] reverseEncryption(byte[] data , byte[] key) {
        System.out.println("Please enter the desired algorithm :\n" +
                "Enter 1 for Caesar, 2 for Xor, 3 for Multiplication");
        encryptionOptions type = validator.verifyReverseTypeAlgorithm(userInput.getScanner().nextLine());
        byte[] decData;
        switch(type) {
            case CAESAR -> decData = encryptCaesarData(data , key);
            case XOR -> decData = XorData(data , key);
            case MULTIPLICATION -> decData = encryptMultiplyingData(data , key);
            default -> decData = null;
        }
        return decData;
    }

    public byte[] reverseDecryption(byte[] data , byte[] key) {
        System.out.println("Please enter the desired algorithm :");
        System.out.println("Enter 1 for Caesar, 2 for Xor, 3 for Multiplication");
        encryptionOptions type = validator.verifyReverseTypeAlgorithm(userInput.getScanner().nextLine());
        byte[] encData;
        switch(type) {
            case CAESAR -> encData = decryptCaesarData(data , key);
            case XOR -> encData = XorData(data , key);
            case MULTIPLICATION -> encData = decryptMultiplyingData(data , key);
            default -> encData = null;
        }
        return encData;
    }

    public byte[] getEncData(byte[] data , encryptionOptions encryptionOption) {
        byte[] key = generateRandomEncryptKey();
        byte[] encData;
        switch(encryptionOption) {
            case CAESAR -> encData = encryptCaesarData(data , key);
            case XOR -> encData = XorData(data , key);
            case MULTIPLICATION -> encData = encryptMultiplyingData(data , key);
            case REVERSE -> encData = reverseDecryption(data , key);
            default -> encData = decryptMultiplyingData(data , key);
        }
        return encData;
    }

    public byte[] getDecData(byte[] data , encryptionOptions encryptionOption) {
        byte[] key = userInput.keyInput();
        byte[] decData;
        switch(encryptionOption) {
            case CAESAR -> decData = decryptCaesarData(data , key);
            case XOR -> decData = XorData(data , key);
            case MULTIPLICATION -> decData = decryptMultiplyingData(data , key);
            case REVERSE -> decData = reverseEncryption(data , key);
            default -> decData = null;
        }
        return decData;
    }
}