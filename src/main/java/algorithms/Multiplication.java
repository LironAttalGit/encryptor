package algorithms;

import fileManager.FileManager;

import java.io.File;
import java.util.Random;

public class Multiplication implements IAlgorithm {
    FileManager fileManager = new FileManager();

    byte[] key;

    public Multiplication() {
        this.key = fileManager.readDataFromFile(generateRandomEncryptKey().getPath());
    }

    public Multiplication(File keyFile) {
        this.key = fileManager.readDataFromFile(keyFile.getPath());
    }

    @Override
    public byte encrypt(byte b) {
        return (byte) (b * key[0]);
    }

    @Override
    public byte decrypt(byte b) {
        byte decKey = decKey(key[0]);
        return (byte) (b * decKey);
    }

    public byte decKey(byte key) {
        byte keyDec = 0;
        for (byte i = Byte.MIN_VALUE; i < Byte.MAX_VALUE; i++) {
            if ((byte) (i * key) == (byte) (1)) {
                keyDec = i;
                break;
            }
        }
        return keyDec;
    }

    public File generateRandomEncryptKey() {
        File keyFile = fileManager.createNewFile("mul_key.bin", "G:\\encryptor\\Files");
        Random rand = new Random();
        byte[] key = new byte[1];
        do {
            rand.nextBytes(key);
        } while (key[0] % 2 == 0);
        fileManager.writeDataToFile(keyFile, key);
        return keyFile;
    }

}