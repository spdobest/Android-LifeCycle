package spandroid.androidlifecycle.pureJavaObserver

import java.util.*

data class MyObservebleModel(val name:String,val emailId:String): Observable() {

    // https://www.javaworld.com/article/2077258/learn-java/observer-and-observable.html

    private var n = 0
    fun ObservableValue(n: Int) {
        this.n = n
    }

    fun setValue(n: Int) {
        this.n = n
        setChanged()
        notifyObservers()
    }

    fun getValue(): Int {
        return n
    }

}