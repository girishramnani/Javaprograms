package observer.working;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Girish on 21-03-2015.
 */
public class DataGenerator {

    public static List<Integer> generateFibo() {
        List<Integer> li = new ArrayList<>();
        li.add(0);
        li.add(1);
        for(int j=1;j<10;j++){
            li.add(li.get(j)+li.get(j-1));
        }
        return li;
    }
    public static List<String> generateFiboString() {
        List<String> li = new ArrayList<>();
        li.add(0+"");
        li.add(1+"");
        for(int j=1;j<10;j++){
            li.add((li.get(j)+li.get(j-1))+"");
        }
        return li;
    }
}
