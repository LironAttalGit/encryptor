package dataManipulation;

import algorithms.IAlgorithm;

import java.util.Random;

public class DataManipulation {

    public byte[] generateRandomEncryptKey() {
        Random rand = new Random();
        byte[] key = new byte[1];
        rand.nextBytes(key);
        System.out.format("The key is : %d\n" , key[0]);
        return key;
    }

    public byte[] getEncData(byte[] data , IAlgorithm algorithm , byte[] key) {
        byte[] encData = new byte[data.length];
        for(int i = 0 ; i < data.length ; i++) {
            encData[i] = algorithm.encrypt(data[i] , key[0]);
        }
        return encData;
    }

    public byte[] getDecData(byte[] data , IAlgorithm algorithm , byte[] key) {
        byte[] decData = new byte[data.length];
        for(int i = 0 ; i < data.length ; i++) {
            decData[i] = algorithm.decrypt(data[i] , key[0]);
        }
        return decData;
    }
}