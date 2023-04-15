package algorithms;

import fileManager.FileManager;

import java.io.File;
import java.util.Random;

public class Caesar implements IAlgorithm {

    byte[] key;

    public Caesar() {
        this.key = fileManager.readDataFromFile(generateRandomEncryptKey().getPath());
    }

    public Caesar(String keyFile) {
        this.key = fileManager.readDataFromFile(keyFile);
    }

    FileManager fileManager = new FileManager();

    @Override
    public byte encrypt(byte b) {
        return (byte) (b + key[0]);
    }

    @Override
    public byte decrypt(byte b) {
        return (byte) (b - key[0]);
    }

    public File generateRandomEncryptKey() {
        File keyFile = fileManager.createNewFile("caesar_key.bin", "G:\\encryptor\\Files");
        Random rand = new Random();
        byte[] key = new byte[1];
        rand.nextBytes(key);
        fileManager.writeDataToFile(keyFile, key);
        return keyFile;
    }
}