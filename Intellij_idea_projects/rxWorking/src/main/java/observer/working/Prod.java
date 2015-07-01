package observer.working;

/**
 * Created by Girish on 22-03-2015.
 */
public class Prod implements Runnable {
        String x2;
        Integer y;

        public Prod(String str, Integer x) {

            x2 = str;
            y = x;

        }

        public void run() {
            while (true) {
                synchronized (x2) {

                    System.out.println("Producer " + this.x2 + "by " + this.y);

                }
                try {
                    notify();
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

