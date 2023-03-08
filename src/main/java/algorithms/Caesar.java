package algorithms;

public class Caesar implements IAlgorithm {
    @Override
    public byte encrypt(byte b , byte key) {
        return (byte) (b + key);
    }

    @Override
    public byte decrypt(byte b , byte key) {
        return (byte) (b - key);
    }
}