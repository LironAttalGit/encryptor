package fileManager;

import java.io.*;

public class FileManager {

    public File createNewFile(String fileName, String path) {
        System.out.println("Trying to create file with the name : " + fileName);
        return new File(path, fileName);
    }

    public void writeDataToFile(File destFile, byte[] dataToWrite) {
        try {
            System.out.println("Writing data to file");
            FileOutputStream fOut = new FileOutputStream(destFile);
            ObjectOutputStream out = new ObjectOutputStream(fOut);
            out.writeObject(dataToWrite);
            out.close();
            fOut.close();
        } catch (IOException e) {
            System.out.println("write operation was not successful");
        }
    }

    public byte[] readDataFromFile(String path) {
        try {
            System.out.println("Reading data to file");
            FileInputStream fileInputStream = new FileInputStream(path);
            ObjectInputStream out = new ObjectInputStream(fileInputStream);
            return out.readAllBytes();
        } catch (IOException e) {
            System.out.println("read operation was not successful");
            throw new RuntimeException("Key file is invalid");
        }
    }
}