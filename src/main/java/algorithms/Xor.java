package algorithms;

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
}