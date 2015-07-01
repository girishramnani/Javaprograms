package com.girish;

import java.nio.file.Path;

/**
 * Created by Girish on 24-02-2015.
 */
public interface Hasher {

    public byte[] hash(Path file);

}
