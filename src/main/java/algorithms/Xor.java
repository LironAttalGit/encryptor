package algorithms;

import fileManager.FileManager;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Random;

public class Xor implements IAlgorithm {
    FileManager fileManager = new FileManager();

    @Override
    public byte encrypt(byte b , byte key) {
        return (byte) (b ^ key);
    }

    @Override
    public byte decrypt(byte b , byte key) {
        if(key % 2 == 0) {
            throw new RuntimeException("Key value is invalid");
        }
        return (byte) (b ^ key);
    }

    public byte[] generateRandomEncryptKey() {
        File keyFile = fileManager.createNewFile("key.bin" , "G:\\encryptor\\Files");
        Random rand = new Random();
        byte[] key = new byte[1];
        rand.nextBytes(key);
        fileManager.writeDataToFile(keyFile , key);
        return key;
    }
}