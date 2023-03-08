package algorithms;

public class Multiplication implements IAlgorithm {

    @Override
    public byte encrypt(byte b , byte key) {
        return (byte) (b * key);
    }

    @Override
    public byte decrypt(byte b , byte key) {
        byte decKey = decKey(key);
        return (byte) (b * decKey);
    }

    public byte decKey(byte key) {
        byte keyDec = 0;
        for(byte i = Byte.MIN_VALUE ; i < Byte.MAX_VALUE ; i++) {
            if((byte) (i * key) == (byte) (1)) {
                keyDec = i;
                break;
            }
        }
        return keyDec;
    }
}