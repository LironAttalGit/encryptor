package dataManipulation;

import algorithms.IAlgorithm;

public class DataManipulation {


    public byte[] encryptData(byte[] data , IAlgorithm algorithm , byte[] key) { //change name
        byte[] encData = new byte[data.length];
        for(int i = 0 ; i < data.length ; i++) {
            encData[i] = algorithm.encrypt(data[i] , key[0]);
        }
        return encData;
    }

    public byte[] decryptData(byte[] data , IAlgorithm algorithm , byte[] key) {// change name
        byte[] decData = new byte[data.length];
        for(int i = 0 ; i < data.length ; i++) {
            decData[i] = algorithm.decrypt(data[i] , key[0]);
        }
        return decData;
    }
}