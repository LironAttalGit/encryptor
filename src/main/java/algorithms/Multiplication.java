package algorithms;

import fileManager.FileManager;

import java.io.File;
import java.util.Random;

public class Multiplication implements IAlgorithm {
    FileManager fileManager = new FileManager();

    public Multiplication() {
    }


    @Override
    public byte encrypt(byte key , byte b) {
        return (byte) (b * key);
    }

    @Override
    public byte encrypt(byte b) {
        return 0;
    }

    @Override
    public byte decrypt(byte key , byte b) {
        byte decKey = decKey(key);
        return (byte) (b * decKey);
    }

    @Override
    public byte decrypt(byte b) {
        return 0;
    }

    public byte decKey(byte key) {
        byte keyDec = 0;
        for(byte i = Byte.MIN_VALUE ; i < Byte.MAX_VALUE ; i++) {
            if((byte) (i * key) == (byte) (1)) {
                keyDec = i;
                break;
            }
        }
        return keyDec;
    }

    public File generateRandomEncryptKey(File keyFile) {
        Random rand = new Random();
        byte[] key = new byte[1];
        do {
            rand.nextBytes(key);
        } while(key[0] % 2 == 0);
        fileManager.writeDataToFile(keyFile , key);
        return keyFile;
    }

}