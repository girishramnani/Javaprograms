import cafe.image.jpeg.JPEGTweaker;
import cafe.image.meta.exif.Exif;
import cafe.image.meta.exif.ExifTag;
import cafe.image.meta.exif.JpegExif;
import cafe.image.tiff.FieldType;

import java.io.FileInputStream;
import java.io.FileOutputStream;


public class ExifTest {
    public static void main(String[] args) throws Exception {
        FileInputStream fin = new FileInputStream("C:\\Users\\Girish\\IdeaProjects\\imageWorks\\src\\main\\resources\\index.jpg");
        FileOutputStream fout = new FileOutputStream("thumbnailAdded.jpg");
        JPEGTweaker.insertExif(fin,fout,populateExif(),true);
        fin.close();
        fout.close();
    }

    // This method is for testing only
    private static Exif populateExif() throws Exception {
        // Create an EXIF wrapper
        Exif exif = new JpegExif();
        exif.addExifField(ExifTag.USER_COMMENT, FieldType.ASCII, "Tarang Dave");


        return exif;
    }
}

