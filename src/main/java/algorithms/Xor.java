package algorithms;

import fileManager.FileManager;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Random;

public class Xor implements IAlgorithm {
    FileManager fileManager = new FileManager();

    byte[] key;

    public Xor() {
//        this.key = fileManager.readDataFromFile(generateRandomEncryptKey().getPath());
    }

//    public Xor(File keyFile) {
//        this.key = fileManager.readDataFromFile(keyFile.getPath());
//    }

    @Override
    public byte encrypt(byte b) {
        return (byte) (b ^ key[0]);
    }

    @Override
    public byte decrypt(byte b) {
        if (key[0] % 2 == 0) {
            throw new RuntimeException("Key value is invalid");
        }
        return (byte) (b ^ key[0]);
    }

    public File generateRandomEncryptKey() {
        File keyFile = fileManager.createNewFile("key.bin", "G:\\encryptor\\Files");
        Random rand = new Random();
        byte[] key = new byte[1];
        rand.nextBytes(key);
        fileManager.writeDataToFile(keyFile, key);
        return keyFile;
    }
}