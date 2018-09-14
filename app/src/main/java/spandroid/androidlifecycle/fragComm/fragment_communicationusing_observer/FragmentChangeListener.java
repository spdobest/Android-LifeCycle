package spandroid.androidlifecycle.fragComm.fragment_communicationusing_observer;

public interface FragmentChangeListener {
    void register(Observer observer);
    void unregister(Observer observer);
    void notifyObservers();
}