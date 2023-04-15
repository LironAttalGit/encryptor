package algorithms;

import java.io.File;

public class Reverse implements IAlgorithm {

    private final IAlgorithm algorithm;

    public Reverse(IAlgorithm algo) {
        this.algorithm = algo;
    }

    @Override
    public byte encrypt(byte b) {
        return algorithm.decrypt(b);
    }

    @Override
    public byte decrypt(byte b) {
        return algorithm.encrypt(b);
    }

    @Override
    public File generateRandomEncryptKey() {
        return algorithm.generateRandomEncryptKey(); //TODO:fix this
    }
}