package main;

import fileManager.FileManager;
import validators.Validators;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import static consts.Const.decrypt;
import static consts.Const.encrypt;

public class Main {


    private void printCoco(int number) {
        System.out.printf("Coco %s%n" , number);
    }
    Scanner scanner = new Scanner(System.in);
    public void run() throws IOException {
        Validators validator = new Validators();
        FileManager fileManager = new FileManager();
        String type = validator.verifyIfEncryptOrDecrypt(scanner);
        String path = validator.verifyIfPathValid(scanner);
        File file = new File(path);
        switch(type) {
            case encrypt -> fileManager.encryptToFile(file);
            case decrypt -> fileManager.decryptToFile(file , scanner);
        }
        scanner.close();
    }

    public static void main(String[] args) throws IOException {
        new Main().run();
    }
}
