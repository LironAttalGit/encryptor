package algorithms;

public class Reverse implements IAlgorithm {

    private final IAlgorithm algorithm;

    public Reverse(IAlgorithm algo) {
        this.algorithm = algo;
    }

    @Override
    public byte encrypt(byte b , byte key) {
        return algorithm.decrypt(b , key);
    }

    @Override
    public byte decrypt(byte b , byte key) {
        return algorithm.encrypt(b , key);
    }
}