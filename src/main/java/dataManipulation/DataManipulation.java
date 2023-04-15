package dataManipulation;

import algorithms.IAlgorithm;
import fileManager.FileManager;

public class DataManipulation {

    FileManager fileManager = new FileManager();

    public byte[] encryptData(byte[] data, IAlgorithm algorithm) { //change name
        byte[] encData = new byte[data.length];
        for (int i = 0; i < data.length; i++) {
            encData[i] = algorithm.encrypt(data[i]);
        }
        return encData;
    }

    public byte[] decryptData(byte[] data, IAlgorithm algorithm) {// change name
        byte[] decData = new byte[data.length];
        for (int i = 0; i < data.length; i++) {
            decData[i] = algorithm.decrypt(data[i]);
        }
        return decData;
    }
}