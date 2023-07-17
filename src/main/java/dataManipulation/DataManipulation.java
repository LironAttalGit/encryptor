package dataManipulation;

import algorithms.IAlgorithm;
import fileManager.FileManager;

public class DataManipulation {

    public byte[] encryptData(byte[] data , byte[] key , IAlgorithm[] algorithm) { //change name
        for(int j = 0 ; j < key.length ; j++) {
            for(int i = 0 ; i < data.length ; i++) {
                data[i] = algorithm[j].encrypt(key[j] , data[i]);
            }
        }
        return data;
    }

    public byte[] decryptData(byte[] data , byte[] key , IAlgorithm[] algorithm) {// change name
        for(int j = algorithm.length ; j > 0 ; j--) {
            for(int i = 0 ; i < data.length ; i++) {
                data[i] = algorithm[j - 1].decrypt(key[j - 1] , data[i]);
            }
        }
        return data;
    }
}