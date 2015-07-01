import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * Created by Girish on 21-03-2015.
 */
public class Bifunctionworking {

    public static void main(String[] args) {
        BiFunction<String ,String,String> concat = (s,t)-> s+t;
        concat =Bifunctionworking::work;
        System.out.println(concat.apply("work", "play"));



    }

    public static String work(String w, String w2) {
        return w+w2;
    }
    public static void work(String a,String b,Function<String,Void> function){
        function.apply(a+b);

    }
}
