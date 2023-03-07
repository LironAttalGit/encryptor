package algorithms;

public interface IAlgorithm {
    byte encrypt(byte b , byte key);

    byte decrypt(byte b , byte key);
}
