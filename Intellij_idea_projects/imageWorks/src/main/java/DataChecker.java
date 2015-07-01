import cafe.image.jpeg.JPEGTweaker;
import cafe.image.meta.exif.Exif;
import cafe.image.meta.exif.ExifTag;
import cafe.image.meta.exif.JpegExif;
import cafe.image.tiff.FieldType;
import com.drew.imaging.ImageMetadataReader;
import com.drew.imaging.ImageProcessingException;
import com.drew.metadata.Directory;
import com.drew.metadata.Tag;

import java.io.*;
import java.util.ArrayList;
import java.util.function.Consumer;

/**
 * Created by Girish on 05-04-2015.
 */
public class DataChecker {
    private FileInputStream fin;
    private FileOutputStream fout;
    private String filename;
    public DataChecker(String filename) {
        try {
            this.filename =filename;
            fin = new FileInputStream(filename);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    public void AddHash(String data,String outputFile) throws Exception {
        this.fout = new FileOutputStream(outputFile);
        JPEGTweaker.insertExif(fin, this.fout,populateExif(data) , true);

    }
    public boolean checkHash(String hash){
        try {
            File jpgFile = new File(filename);
            com.drew.metadata.Metadata metadata = ImageMetadataReader.readMetadata(jpgFile);

            final ArrayList<Directory> li = new ArrayList<Directory>();


            metadata.getDirectories().forEach(new Consumer<Directory>() {
                @Override
                public void accept(Directory directory) {
                    li.add(directory);
                }
            });
            Directory dr2 = li.get(5);
            for(Tag x: dr2.getTags() ){
                if(x.getTagName() =="User Comment")
                    return x.getDescription()==hash;
            }

        } catch (ImageProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }


    private Exif populateExif(String data) throws Exception {
        // Create an EXIF wrapper
        Exif exif = new JpegExif();
        exif.addExifField(ExifTag.USER_COMMENT, FieldType.ASCII,data );
        return exif;
    }
}
