package fileManager;

import dataManipulation.DataManipulation;

import java.io.*;
import java.util.Scanner;

public class FileManager {
    DataManipulation dataManipulation = new DataManipulation();

    public File createNewFile(String fileName , String path) {
        File newFile = new File(path , fileName);
        try {
            if(newFile.createNewFile()) {
                System.out.println("File created");
            } else {
                System.out.println("File already exists.");
            }
        } catch(IOException e) {
            System.out.println("error : " + e.getLocalizedMessage());
            e.printStackTrace();
        }
        return newFile;
    }

    public void writeEncryptedDataToFile(File destFile , byte[] data) throws IOException {
        OutputStream outputStream = new FileOutputStream(destFile);
        outputStream.write(dataManipulation.encryptData( dataManipulation.generateRandomEncryptKey(),data));
        outputStream.close();
    }


    public void encryptToFile(File file) throws IOException {
        File destFile = createNewFile(file.getName().concat(".encrypted") , file.getParent());
        InputStream fileInputStream = new FileInputStream(file);
        writeEncryptedDataToFile(destFile , dataManipulation.getByte(fileInputStream));
        fileInputStream.close();
    }

    public void writeDecryptedDataToFile(File destFile , byte[] data , Scanner scanner) throws IOException {
        OutputStream outputStream = new FileOutputStream(destFile);
        outputStream.write(dataManipulation.decryptData(data , dataManipulation.keyInput(scanner)));
        outputStream.close();
    }

    public void decryptToFile(File file , Scanner scanner) throws IOException {
        File destFile = createNewFile(file.getName().concat(".decrypted") , file.getParent());
        InputStream inputStream = new FileInputStream(file);
        writeDecryptedDataToFile(destFile , dataManipulation.getByte(inputStream) , scanner);
        inputStream.close();
    }
}