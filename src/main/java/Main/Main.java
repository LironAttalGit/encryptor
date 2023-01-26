package Main;

import lombok.NoArgsConstructor;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;
import java.util.random.RandomGenerator;

public class Main {

    // TODO: to move the scanner outside 26/01/2023
    Main() throws FileNotFoundException {
        System.out.println("Please choose 1 for encrypt or  2 for decrypt:");
        Scanner in = new Scanner(System.in);
        String type = in.nextLine();
        type = verifyIfEncryptOrDecrypt(in , type);
        System.out.println("Please enter the path:");
        String path = in.next();
        path = verifyIfPathValid(in , path);
        File file = new File(path);
        System.out.println("displaying data from file");
        displayDataFromFile(file);
//        Random rand = new Random();
//        int key = rand.nextInt(25);
//        switch(type) {
//            case "encryptor":
//                System.out.println("The random key is: " + key);
//
//                break;
//            case "decryptor":
//                break;
//        }
    }

    public boolean isPathRight(String path) {
        Path path1 = Path.of(path);
        return Files.exists(path1) && ! Files.isDirectory(path1);
    }

    // TODO: displayDataFromFile doesn't needed to display to console and to change it to write to a file 26/01/2023
    public void displayDataFromFile(File file) throws FileNotFoundException {
        Scanner sc = new Scanner(file);
        sc.useDelimiter("\\Z");
        System.out.println(sc.next());

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

    public static void main(String[] args) throws FileNotFoundException {
        Main a = new Main();
    }
}
