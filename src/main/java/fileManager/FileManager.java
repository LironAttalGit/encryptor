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

    //TODO: The input does not match.
    public void encryptToFile(File file) throws IOException {
        byte[] key = dataManipulation.generateRandomEncryptKey();
        File destFile = createNewFile(file.getName().concat(".encrypted") , file.getParent());
        InputStream fileInputStream = new FileInputStream(file);
        OutputStream outputStream = new FileOutputStream(destFile);
        byte[] dataFromFile = fileInputStream.readAllBytes();
        outputStream.write(dataManipulation.encryptData(dataFromFile , key));
        fileInputStream.close();
        outputStream.close();
    }

    public void decryptToFile(File file , Scanner scanner) throws IOException {
        System.out.println("Enter the decryption key: ");
        byte[] key = new byte[1];
        key[0] = scanner.nextByte();
        System.out.println("The key is : " + key[0]);
        File destFile = createNewFile(file.getName().concat(".decrypted") , file.getParent());
        InputStream inputStream = new FileInputStream(file);
        OutputStream outputStream = new FileOutputStream(destFile);
//        byte[] dataFromFile = inputStream.readAllBytes();
//        outputStream.write(dataManipulation.decryptData(dataFromFile , key));
        outputStream.write(dataManipulation.decryptData(inputStream.readAllBytes(),key));
        //TODO: to check if above is ok by Aviv
        inputStream.close();
        outputStream.close();
    }
}