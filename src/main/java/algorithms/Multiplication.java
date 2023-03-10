package algorithms;

import java.util.Random;

public class Multiplication implements IAlgorithm {

    @Override
    public byte encrypt(byte b , byte key) {
        return (byte) (b * key);
    }

    @Override
    public byte decrypt(byte b , byte key) {
        byte decKey = decKey(key);
        return (byte) (b * decKey);
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

    public byte[] generateRandomEncryptKey() {
        Random rand = new Random();
        byte[] key = new byte[1];
        do {
            rand.nextBytes(key);
        } while(key[0] % 2 == 0);
        System.out.format("The key is : %d\n" , key[0]);
        return key;
    }

}