package Main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.util.Random;
import java.util.Scanner;

public class Main {

    // TODO: to move the scanner outside 26/01/2023

    Scanner in = new Scanner(System.in);

    Main() throws IOException {
        System.out.println("Please choose 1 for encrypt or  2 for decrypt:");
        String type = in.nextLine();
        type = verifyIfEncryptOrDecrypt(in , type);
        System.out.println("Please enter the path:");
        String path = in.next();
        path = verifyIfPathValid(in , path);
        Random rand = new Random();
        int key;
        File file = new File(path);
        switch(type) {
            case "1":
                key = rand.nextInt(25);
                System.out.println("The random key is: " + key);
                encryptToFile(file , key);

                break;
            case "2":
                break;
        }

        in.close();
    }

    public File createNewFile(String fileName , String path) {
        File newFile = new File(path , fileName);
        try {
            if(newFile.createNewFile()) {
                System.out.println("File created");
            } else {
                System.out.println("File already exists.");
            }
        } catch(IOException e) {
            System.out.println("error : ");
            e.printStackTrace();
        }
        return newFile;
    }

    public void encryptToFile(File file , int key) throws IOException {
        Scanner scanFile = new Scanner(file);
        StringBuilder dataAfterEncryption = new StringBuilder();
        File destFile = createNewFile(file.getName().concat(".encrypted") , file.getParent());
        for(char character : scanFile.toString().toCharArray()) {
            if(character != ' ') {
                int originalAlphabetPosition = character - 'a';
                int newAlphabetPosition = (originalAlphabetPosition + key) % 26;
                char newCharacter = (char) ('a' + newAlphabetPosition);
                dataAfterEncryption.append(newCharacter);
            } else {
                dataAfterEncryption.append(character);
            }
        }
        scanFile.close();
        Files.writeString(Path.of(destFile.getPath()) , dataAfterEncryption , StandardCharsets.UTF_8);
    }

    public boolean isPathRight(String path) {
        Path path1 = Path.of(path);
        return Files.exists(path1) && ! Files.isDirectory(path1);
    }


    public String verifyIfEncryptOrDecrypt(Scanner scanner , String data) {
        do {
            if(data.equals("1") || data.equals("2")) {
                break;
            }
            System.out.println("Please choose 1 for encrypt or  2 for decrypt");
            data = scanner.nextLine();
        } while(! data.equals("1") || ! data.equals("2"));
        return data;
    }

    public String verifyIfPathValid(Scanner scanner , String path) {
        do {
            if(isPathRight(path)) {
                System.out.println("The path is valid");
                break;
            }
            System.out.println("error, path is not valid, enter path again:");
            path = scanner.next();
        } while(! isPathRight(path));
        return path;
    }

    public static void main(String[] args) throws IOException {
        Main a = new Main();
    }
}
