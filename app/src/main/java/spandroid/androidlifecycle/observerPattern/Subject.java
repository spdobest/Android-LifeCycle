package spandroid.androidlifecycle.observerPattern;
public interface Subject {
    public void register(Observer observer);
    public void unregister(Observer observer);
    public void notifyObservers(String message);
}
