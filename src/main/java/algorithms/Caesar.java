package algorithms;

import fileManager.FileManager;

import java.io.File;
import java.nio.file.Path;
import java.util.Random;

public class Caesar implements IAlgorithm {

    public Caesar() {
    }

    FileManager fileManager = new FileManager();

    File keyFile = new File("G:\\encryptor\\Files\\key.bin");

    byte[] key;

    public byte encrypt(byte b) {
        key = fileManager.readDataFromFile(keyFile);
        return (byte) (b + key[0]);
    }

    public byte decrypt(byte b) {
        key = fileManager.readDataFromFile(keyFile);
        return (byte) (b - key[0]);
    }

    public File generateRandomEncryptKey() {
        File keyFile = fileManager.createNewFile("key.bin" , "G:\\encryptor\\Files");
        Random rand = new Random();
        byte[] key = new byte[1];
        rand.nextBytes(key);
        fileManager.writeDataToFile(keyFile , key);
        return keyFile;
    }
}