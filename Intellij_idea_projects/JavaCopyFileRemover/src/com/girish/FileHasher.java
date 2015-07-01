package com.girish;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Girish on 24-02-2015.
 */
public class FileHasher implements Hasher,Comparator<byte[]> {
    private String algorithm;
    private MessageDigest messageDigest;

    public FileHasher(HashType hashType) {
        try {
            messageDigest = MessageDigest.getInstance(hashType.toString());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        algorithm = hashType.name();
    }

    @Override
    public byte[] hash(Path file) {
        try {
            byte[] data = Files.readAllBytes(file);
            data = messageDigest.digest(data);
            return data;

        } catch (IOException e) {
            e.printStackTrace();
            Logger.getAnonymousLogger().log(Level.WARNING,file.getFileName()+" cannot be hashed..");
            return null;

        }

    }

    public static void main(String[] args) {
        FileHasher fileHasher = new FileHasher(HashType.SHA);
        long x = System.nanoTime();

        System.out.println(System.nanoTime()-x);

    }


    @Override
    public int compare(byte[] o1, byte[] o2) {
        /*
        * compares the two hashes given
        *
        * */
        return Arrays.equals((byte[]) o1, (byte[]) o2) ? 1 : 0;

    }
}
