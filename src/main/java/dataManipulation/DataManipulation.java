package dataManipulation;

import userInput.UserInput;

import java.util.Random;

public class DataManipulation {
    UserInput userInput = new UserInput();

    public byte encryptSingleByte(byte b , byte key) {
        return (byte) (b + key);
    }

    public byte decryptSingleByte(byte b , byte key) {
        return (byte) (b - key);
    }

    public byte[] generateRandomEncryptKey() {
        Random rand = new Random();
        byte[] key = new byte[1];
        rand.nextBytes(key);
        System.out.format("The key is : %d\n" , key[0]); //Arrays.toString(key)
        return key;
    }

    public byte[] encryptData(byte[] data , byte[] key) {
        byte[] encData = new byte[data.length];
        for(int i = 0 ; i < data.length ; i++) {
            encData[i] = encryptSingleByte(data[i] , key[0]);
        }
        return encData;
    }

    public byte[] decryptData(byte[] data , byte[] key) {
        byte[] decData = new byte[data.length];
        for(int i = 0 ; i < data.length ; i++) {
            decData[i] = decryptSingleByte(data[i] , key[0]);
        }
        return decData;
    }

    public byte[] getEncData(byte[] data) {
        byte[] key = generateRandomEncryptKey();
        return encryptData(data , key);
    }

    public byte[] getDecData(byte[] data) {
        byte[] key = userInput.keyInput();
        return decryptData(data , key);
    }
}