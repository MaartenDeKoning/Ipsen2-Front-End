package observable;

import observer.HomeObserver;

public interface HomeObservable {
    void addObserver(HomeObserver observer);
    void notifyObservers();
}
