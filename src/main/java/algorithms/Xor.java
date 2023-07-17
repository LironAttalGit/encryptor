package algorithms;

import fileManager.FileManager;

import java.io.File;
import java.util.Random;

public class Xor implements IAlgorithm {
    FileManager fileManager = new FileManager();

//    byte[] key;

    public Xor() {
    }

    @Override
    public byte encrypt(byte key , byte b) {
        return (byte) (b ^ key);
    }

    @Override
    public byte encrypt(byte b) {
        return 0;
    }

    @Override
    public byte decrypt(byte key , byte b) {
        if(key < 0) {
            key*=-1;
            if(key % 2 == 0) {
                throw new RuntimeException("Key value is invalid");
            }
            key*=-1;
        }
        return (byte) (b ^ key);
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