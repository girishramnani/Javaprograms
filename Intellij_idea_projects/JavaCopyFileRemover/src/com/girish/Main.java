package com.girish;

import java.io.IOException;
import java.nio.file.*;

public class Main {

    public static void main(String[] args) {
        try {
            Files.walkFileTree(Paths.get(".."), new SimpleFileVisitor<Path>(){
                @Override
                public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                    System.out.println(dir.toString());

                    return FileVisitResult.CONTINUE;
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
