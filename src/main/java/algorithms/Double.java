package algorithms;

import fileManager.FileManager;

import java.io.File;

public class Double implements IAlgorithm {

    FileManager fileManager = new FileManager();
    IAlgorithm first;
    IAlgorithm second;

    byte[] firstKey;
    byte[] secondKey;

    public Double(IAlgorithm first , IAlgorithm second) {
        this.first = first;
//        this.firstKey = fileManager.readDataFromFile(first.generateRandomEncryptKey().getPath());
//        this.second = second;
//        this.secondKey = fileManager.readDataFromFile(second.generateRandomEncryptKey().getPath());
    }

    @Override
    public byte encrypt(byte key , byte b) {
//        byte b1 = first.encrypt(b, firstKey[0]);
//        return second.encrypt(b1, secondKey[0]);
        return 0;
    }

    @Override
    public byte encrypt(byte b) {
        return 0;
    }

    @Override
    public byte decrypt(byte key , byte b) {
        return 0;
    }

    @Override
    public byte decrypt(byte b) {
        return 0;
    }

    @Override
    public File generateRandomEncryptKey(File keyFile) {
        return null;
    }//TODO: do this
}
