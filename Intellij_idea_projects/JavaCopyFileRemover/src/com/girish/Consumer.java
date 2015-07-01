package com.girish;

import java.nio.file.Path;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;

/**
 * Created by Girish on 25-02-2015.
 */
public class Consumer extends FileHasher implements Runnable {
    private final BlockingQueue<Path> path;
    private byte[] b;
    public Consumer(BlockingQueue<Path> path) {
        super(HashType.SHA);
        this.path = path;
    }

    @Override
    public void run() {


        try {
            while (!path.isEmpty()) {
                Path w = path.take();
                b = hash(w);
                System.out.println(b.toString());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
