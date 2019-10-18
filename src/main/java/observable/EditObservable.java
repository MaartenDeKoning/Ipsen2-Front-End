package observable;

import observer.EditObserver;

public interface EditObservable {
    void addObserver(EditObserver observer);
    void notifyObservers();
}
