package com.girish;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class d2 {

    public static void main(String[] args) {
        try {
            System.out.println(Files.isSameFile(Paths.get("Main.java"), Paths.get("Main.java")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
