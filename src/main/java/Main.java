import lombok.Lombok;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;
import java.util.random.RandomGenerator;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("Please choose encryptor or decryptor:");
        Scanner in = new Scanner(System.in);
        String type = in.next();
        while(true) {
            if(type.equals("encryptor") || type.equals("decryptor")) {
                break;
            }
            System.out.println("please choose encryptor or decryptor.");
            type = in.next();
        }
        System.out.println(String.format("Please enter the path to %s:" , type));
        String path = in.next();

        while(! isPathRight(path)) {
            System.out.println("error, path is not valid, enter path again:");
            path = in.next();
            if(isPathRight(path)) {
                System.out.println("The path is valid");
                break;
            }
        }
        File file = new File(path);
        System.out.println("displaying data from file");
        displayDataFromFile(file);
        Random rand = new Random();
        int key = rand.nextInt(25);
        switch(type) {
            case "encryptor":
                System.out.println("The random key is: " + key);

                break;
            case "decryptor":
                break;
        }
    }

    public static boolean isPathRight(String path) {
        boolean result;
        File file = new File(path);
        result = file.isFile();
        return result;
    }

    public static void displayDataFromFile(File file) throws FileNotFoundException {
        Scanner sc = new Scanner(file);
        sc.useDelimiter("\\Z");
        System.out.println(sc.next());
    }

}
