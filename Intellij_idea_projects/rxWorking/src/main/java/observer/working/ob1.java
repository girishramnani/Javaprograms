package observer.working;

import rx.Observable;
import rx.Scheduler;

/**
 * Created by Girish on 21-03-2015.
 */
public class ob1 {
    public static void main(String[] args) {
        Observable<Integer> x = Observable.from(DataGenerator.generateFibo());

        x.subscribe((i)-> System.out.println(i));



    }
}
