package algorithms;

import java.io.File;

public interface IAlgorithm {
    byte encrypt(byte key , byte b);

    byte encrypt(byte b);

    byte decrypt(byte key , byte b);

    byte decrypt(byte b);

    File generateRandomEncryptKey(File key);
}