package algorithms;

import fileManager.FileManager;

import java.io.File;
import java.util.Random;

public class Caesar implements IAlgorithm {

    public Caesar() {

    }

    FileManager fileManager = new FileManager();

    public byte encrypt(byte key , byte b) {
        return (byte) (b + key);
    }

    @Override
    public byte encrypt(byte b) {
        return 0;
    }

    public byte decrypt(byte key , byte b) {
        return (byte) (b - key);
    }

    @Override
    public byte decrypt(byte b) {
        return 0;
    }

    public File generateRandomEncryptKey(File keyFile) {
        Random rand = new Random();
        byte[] key = new byte[1];
        rand.nextBytes(key);
        fileManager.writeDataToFile(keyFile , key);
        return keyFile;
    }
}