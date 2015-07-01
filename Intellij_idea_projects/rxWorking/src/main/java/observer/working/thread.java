package observer.working;

/**
 * Created by Girish on 22-03-2015.
 */
public class thread {



    public static void main(String[] args) {

        String x2 = new String("grisih");

        Prod x = new Prod(x2,1);
        Prod x3 =new Prod(x2,2);
        new Thread(x).start();
        new Thread(x3).start();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
