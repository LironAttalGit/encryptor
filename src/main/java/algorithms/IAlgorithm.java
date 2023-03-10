package algorithms;

import java.util.Random;

public interface IAlgorithm {
    byte encrypt(byte b , byte key);

    byte decrypt(byte b , byte key);

    public byte[] generateRandomEncryptKey() ;
}