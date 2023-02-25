package fileManager;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class FileManager {

    public File createNewFile(String fileName , String path) {
        System.out.println("Trying to create file with the name : " + fileName);
        return new File(path , fileName);
    }

    public void writeDataToFile(File destFile , byte[] dataToWrite) throws IOException {
        System.out.println("Writing data to file");
        Files.write(destFile.toPath() , dataToWrite);
    }


}