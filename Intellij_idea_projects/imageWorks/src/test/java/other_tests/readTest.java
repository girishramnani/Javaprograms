package other_tests; /**
 * Created by Girish on 05-04-2015.
 */
import cafe.image.meta.Metadata;
import cafe.image.meta.MetadataType;

import java.io.IOException;
import java.util.Map;

public class readTest {

    public static void main(String[] args) throws IOException {
        Map<MetadataType, Metadata> metadataMap = Metadata.readMetadata("thumbnailAdded.jpg");
        System.out.println("Start of metadata information:");
        System.out.println("Total number of metadata entries: " + metadataMap.size());
        int i = 0;
        Metadata metadata =metadataMap.get(MetadataType.EXIF);

    }
}