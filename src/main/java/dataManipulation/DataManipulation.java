package dataManipulation;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class DataManipulation {
    public byte encryptSingleByte(byte b , byte key) {
        return (byte) (b + key);
    }

    public byte decryptSingleByte(byte b , byte key) {
        return (byte) (b - key);
    }

    public byte[] getByte(InputStream inputStream) throws IOException {
        return inputStream.readAllBytes();
    }

    public byte[] keyInput(Scanner scanner) {
        System.out.println("Enter the decryption key: ");
        byte[] key = new byte[1];
        key[0] = scanner.nextByte();
        System.out.println("The key is : " + key[0]);
        return key;
    }

    public byte[] generateRandomEncryptKey() {
        Random rand = new Random();
        byte[] key = {};
        rand.nextBytes(key);
        System.out.println("The random key is: " + Arrays.toString(key));
        return key;
    }

    public byte[] encryptData(byte[] key,byte[] data) {
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