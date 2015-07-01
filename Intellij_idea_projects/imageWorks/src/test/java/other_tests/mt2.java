package other_tests;

import java.io.File;

/**
 * Created by Girish on 05-04-2015.
 */
public class mt2 {
    public static void main(String[] args) {
        Metadata meta = new Metadata();
        String filename = "C:\\Users\\Girish\\IdeaProjects\\imageWorks\\src\\main\\resources\\index.jpg";

        if (new File(filename).exists()) {
            meta.readAndDisplayMetadata(filename);
        } else {
            System.out.println("cannot find file: " + filename);
        }
    }
}
