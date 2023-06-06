package fileManager;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class FileManager {

    public File createNewFile(String fileName , String path) {
        System.out.println("Trying to create file with the name : " + fileName);
        return new File(path , fileName);
    }

    public void writeDataToFile(File destFile , byte[] dataToWrite) {
        try {
            System.out.println("Writing data to file");
            Files.write(destFile.toPath(),dataToWrite);
        } catch(IOException e) {
            System.out.println("write operation was not successful");
        }
    }

    public byte[] readDataFromFile(File file) {
        try {
            System.out.println("Reading data from file");
            return Files.readAllBytes(file.toPath());
        } catch(IOException e) {
            System.out.println("Read operation was not successful");
            throw new RuntimeException("File is invalid");
        }
    }
}