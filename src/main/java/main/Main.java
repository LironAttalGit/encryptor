package main;

import encryptor.Encryptor;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        Encryptor encryptor = new Encryptor();//todo: find a different name for RUN
        encryptor.start();
    }
}
