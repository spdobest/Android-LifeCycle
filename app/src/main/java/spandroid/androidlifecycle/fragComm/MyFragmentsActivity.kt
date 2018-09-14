package spandroid.androidlifecycle.fragComm

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import spandroid.androidlifecycle.R
import spandroid.androidlifecycle.activity.LifeCycleActivity
import spandroid.androidlifecycle.utility.LogUtils

class MyFragmentsActivity : AppCompatActivity() {

    companion object {
        val TAG = "MyActivityBroadcast"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragments)

        LogUtils.printLog(LifeCycleActivity.TAG, "OnCreate()")
    }

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        LogUtils.printLog(LifeCycleActivity.TAG, "OnCreate() with persistentState")
    }

    override fun onStart() {
        super.onStart()
        LogUtils.printLog(LifeCycleActivity.TAG, "onStart()")
    }

    override fun onResume() {
        super.onResume()
        LogUtils.printLog(LifeCycleActivity.TAG, "onResume()")
    }

    override fun onPause() {
        super.onPause()
        LogUtils.printLog(LifeCycleActivity.TAG, "onPause(0")
    }

    override fun onStop() {
        super.onStop()
        LogUtils.printLog(LifeCycleActivity.TAG, "onStop()")
    }

    override fun onRestart() {
        super.onRestart()
        LogUtils.printLog(LifeCycleActivity.TAG, "onRestart()")
    }

    override fun onDestroy() {
        super.onDestroy()
        LogUtils.printLog(LifeCycleActivity.TAG, "onDestroy()")
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        LogUtils.printLog(LifeCycleActivity.TAG, "onSaveInstanceState()")
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)
        LogUtils.printLog(LifeCycleActivity.TAG, "onRestoreInstanceState()")
    }


    override fun onTrimMemory(level: Int) {
        super.onTrimMemory(level)
        LogUtils.printLog(LifeCycleActivity.TAG, "onTrimMemory(${level})")
    }

    override fun onLowMemory() {
        super.onLowMemory()
        LogUtils.printLog(LifeCycleActivity.TAG, "onLowMemory()")
    }


}
