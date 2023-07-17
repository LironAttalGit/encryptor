package algorithms;

import java.io.File;

public class Reverse implements IAlgorithm {

    private final IAlgorithm algorithm;

    public Reverse(IAlgorithm algo) {
        this.algorithm = algo;
    }

    @Override
    public byte encrypt(byte key , byte b) {
        return 0;
    }

    @Override
    public byte encrypt(byte b) {
        return algorithm.decrypt(b);
    }

    @Override
    public byte decrypt(byte key , byte b) {
        return algorithm.encrypt(key , b);
    }

    @Override
    public byte decrypt(byte b) {
        return 0;
    }

    @Override
    public File generateRandomEncryptKey(File keyFile) {
        return algorithm.generateRandomEncryptKey(keyFile); //TODO:fix this
    }
}