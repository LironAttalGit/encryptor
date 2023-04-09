package algorithms;

import java.io.IOException;
import java.util.Random;

public interface IAlgorithm {
    byte encrypt(byte b , byte key);

    byte decrypt(byte b , byte key);

    public byte[] generateRandomEncryptKey();
}