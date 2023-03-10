package algorithms;

import java.util.Random;

public class Xor implements IAlgorithm {
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
        Random rand = new Random();
        byte[] key = new byte[1];
        rand.nextBytes(key);
        System.out.format("The key is : %d\n" , key[0]);
        return key;
    }
}