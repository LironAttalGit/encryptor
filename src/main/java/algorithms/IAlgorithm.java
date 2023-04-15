package algorithms;

import java.io.File;

public interface IAlgorithm {
    byte encrypt(byte b);

    byte decrypt(byte b);

    public File generateRandomEncryptKey();
}