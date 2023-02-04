package dataManipulation;

import java.util.Arrays;
import java.util.Random;

public class DataManipulation {
    public byte encryptSingleByte(byte b , byte key) {
        return (byte) (b + key);
    }

    public byte decryptSingleByte(byte b , byte key) {
        return (byte) (b - key);
    }

    public byte[] generateRandomEncryptKey() {
        Random rand = new Random();
        byte[] key = {};
        rand.nextBytes(key);
        System.out.println("The random key is: " + Arrays.toString(key));
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
}
