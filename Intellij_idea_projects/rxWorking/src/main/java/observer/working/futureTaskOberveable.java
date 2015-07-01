package observer.working;

import rx.Observable;
import rx.Observer;

import java.util.List;

/**
 * Created by Girish on 21-03-2015.
 */
public class futureTaskOberveable {
    public static void main(String[] args) {
        Observer<String> x = new Observer<String>() {
            @Override
            public void onCompleted() {
                System.out.println("completed");

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(String s) {
                System.out.println(s);
            }
        };
        Observable<String> stringObservable = Observable.from(new String[]{"Girish", "Is", "my", "Name"});
        stringObservable.subscribe(x);
    }

}
