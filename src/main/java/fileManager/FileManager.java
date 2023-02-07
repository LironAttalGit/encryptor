package fileManager;

import dataManipulation.DataManipulation;

import java.io.*;


public class FileManager {
    DataManipulation dataManipulation = new DataManipulation();

    public File createNewFile(String fileName , String path) {
        return new File(path , fileName);
    }

    public void writeEncryptedDataToFile(File destFile , byte[] data) throws IOException {
        OutputStream outputStream = new FileOutputStream(destFile);
        byte[] encData = dataManipulation.getEncData(data);
        outputStream.write(encData);
        outputStream.close();
    }


    public void encryptToFile(File file) throws IOException {
        File destFile = createNewFile(file.getName().concat(".encrypted") , file.getParent());
        InputStream fileInputStream = new FileInputStream(file);
        writeEncryptedDataToFile(destFile , dataManipulation.getByte(fileInputStream));
        fileInputStream.close();
    }

    public void writeDecryptedDataToFile(File destFile , byte[] data) throws IOException {
        OutputStream outputStream = new FileOutputStream(destFile);
        byte[] decData = dataManipulation.getDecData(data);
        outputStream.write(decData);
        outputStream.close();
    }

    public void decryptToFile(File file) throws IOException {
        File destFile = createNewFile(file.getName().concat(".decrypted") , file.getParent());
        InputStream inputStream = new FileInputStream(file);
        writeDecryptedDataToFile(destFile , dataManipulation.getByte(inputStream));
        inputStream.close();
    }
}