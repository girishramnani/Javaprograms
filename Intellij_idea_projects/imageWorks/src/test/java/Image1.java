import com.drew.imaging.ImageMetadataReader;
import com.drew.imaging.ImageProcessingException;
import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.Tag;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.function.Consumer;


class Image1 {

    public static void main(String[] args) throws URISyntaxException {

        try {
            File jpgFile = new File("C:\\Users\\Girish\\IdeaProjects\\imageWorks\\thumbnailAdded.jpg");
            Metadata metadata = ImageMetadataReader.readMetadata(jpgFile);

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
                System.out.println(x.getDescription());
            }

        } catch (ImageProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
