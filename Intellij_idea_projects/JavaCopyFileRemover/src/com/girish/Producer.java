package com.girish;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;

/**
 * Created by Girish on 24-02-2015.
 */
public class Producer implements Runnable {


    private final ArrayBlockingQueue<Path> filelist;
    private final Path path;


    public Producer(ArrayBlockingQueue<Path> filelist,Path path){
        this.filelist = filelist;
        this.path = path;
    }

    @Override
    public void run() {
        try {
            Files.walkFileTree(this.path,new SimpleFileVisitor<Path>(){
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    try {
                        filelist.put(file);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return FileVisitResult.CONTINUE;
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayBlockingQueue<Path> getFilelist() {
        return filelist;
    }
}

