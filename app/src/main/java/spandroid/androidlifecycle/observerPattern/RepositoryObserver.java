package spandroid.androidlifecycle.observerPattern;

public interface RepositoryObserver {
    void onUserDataChanged(String fullname, int age);
}