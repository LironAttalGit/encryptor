package fileManager;

import dataManipulation.DataManipulation;

import java.io.*;


public class FileManager {
    DataManipulation dataManipulation = new DataManipulation();

    public File createNewFile(String fileName , String path) {// todo: delete.
        return new File(path , fileName);
    }

    public void writeDataToFile(File destFile , byte[] dataToWrite) throws IOException {
        OutputStream outputStream = new FileOutputStream(destFile);
        outputStream.write(dataToWrite);
        outputStream.close();
    }

    public void encryptToFile(File file) {
        try {
            File destFile = createNewFile(file.getName().concat(".encrypted") , file.getParent());
            InputStream fileInputStream = new FileInputStream(file);
            byte[] data = dataManipulation.getEncData(fileInputStream.readAllBytes());
            writeDataToFile(destFile , data);
            fileInputStream.close();
        } catch(IOException io) {
            System.out.println("There was a problem with the files");
        }
    }

    public void decryptToFile(File file) {
        try {
            File destFile = createNewFile(file.getName().concat(".decrypted") , file.getParent());
            InputStream inputStream = new FileInputStream(file);
            byte[] data = dataManipulation.getDecData(inputStream.readAllBytes());
            writeDataToFile(destFile , data);
            inputStream.close();
        } catch(IOException io) {
            System.out.println("There was a problem with the files");
        }
    }
}