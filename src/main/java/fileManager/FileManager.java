package fileManager;

import dataManipulation.DataManipulation;

import java.io.*;


public class FileManager {
    DataManipulation dataManipulation = new DataManipulation();

    public File createNewFile(String fileName , String path) {// todo: delete.
        return new File(path , fileName);
    }

    public void writeDataToFile(File destFile , byte[] dataToWrite) throws IOException {//todo: to remove the type
        OutputStream outputStream = new FileOutputStream(destFile);
        outputStream.write(dataToWrite);
        outputStream.close();
    }


    public void encryptToFile(File file) throws IOException {
        File destFile = createNewFile(file.getName().concat(".encrypted") , file.getParent());
        InputStream fileInputStream = new FileInputStream(file);
        byte[] data = dataManipulation.getEncData(fileInputStream.readAllBytes());
        writeDataToFile(destFile , data);
        fileInputStream.close();
    }

    public void decryptToFile(File file) throws IOException {
        File destFile = createNewFile(file.getName().concat(".decrypted") , file.getParent());
        InputStream inputStream = new FileInputStream(file);
        byte[] data = dataManipulation.getDecData(inputStream.readAllBytes());
        writeDataToFile(destFile , data);
        inputStream.close();
    }
}