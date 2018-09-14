package spandroid.androidlifecycle.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import kotlinx.android.synthetic.main.activity_life_cycle.*
import spandroid.androidlifecycle.R
import spandroid.androidlifecycle.utility.LogUtils

class CrashActivity : AppCompatActivity() {

    var strLifecycle:StringBuffer = StringBuffer()

    companion object {
        val TAG = "CrashActivity"
    }

    /**
     * WHEN apllication crash on onCreate or onResume
     * it dont call onPause(), onStop() or onDestroy()
     * it Direct exit the application
     */

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crash)

        LogUtils.printLog(LifeCycleActivity.TAG,"OnCreate()")

        strLifecycle.append("onCreate() ")
        textViewLifecycle.text = strLifecycle.toString()
    }

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        LogUtils.printLog(LifeCycleActivity.TAG,"OnCreate() with persistentState")
    }

    override fun onStart() {
        super.onStart()
        LogUtils.printLog(LifeCycleActivity.TAG,"onStart()")
        strLifecycle.append("onStart() ")
        textViewLifecycle.text = strLifecycle.toString()
    }

    override fun onResume() {
        super.onResume()
        LogUtils.printLog(LifeCycleActivity.TAG,"onResume()")
        strLifecycle.append("onResume() ")
        textViewLifecycle.text = strLifecycle.toString()

        System.exit(0)
    }

    override fun onPause() {
        super.onPause()
        LogUtils.printLog(LifeCycleActivity.TAG,"onPause(0")
        strLifecycle.append("onPause() ")
        textViewLifecycle.text = strLifecycle.toString()
    }

    override fun onStop() {
        super.onStop()
        LogUtils.printLog(LifeCycleActivity.TAG,"onStop()")
        strLifecycle.append("onStop() ")
        textViewLifecycle.text = strLifecycle.toString()
    }

    override fun onRestart() {
        super.onRestart()
        LogUtils.printLog(LifeCycleActivity.TAG,"onRestart()")
        strLifecycle.append("onRestart() ")
        textViewLifecycle.text = strLifecycle.toString()
    }

    override fun onDestroy() {
        super.onDestroy()
        LogUtils.printLog(LifeCycleActivity.TAG,"onDestroy()")
        strLifecycle.append("onDestroy() ")
        textViewLifecycle.text = strLifecycle.toString()
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        LogUtils.printLog(LifeCycleActivity.TAG,"onSaveInstanceState()")
        strLifecycle.append("onSaveInstanceState() ")
        textViewLifecycle.text = strLifecycle.toString()
    }

    override fun onSaveInstanceState(outState: Bundle?, outPersistentState: PersistableBundle?) {
        super.onSaveInstanceState(outState, outPersistentState)
        LogUtils.printLog(LifeCycleActivity.TAG,"onSaveInstanceState() with outPersistentState")
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)
        LogUtils.printLog(LifeCycleActivity.TAG,"onRestoreInstanceState()")
        strLifecycle.append("onRestoreInstanceState() ")
        textViewLifecycle.text = strLifecycle.toString()
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onRestoreInstanceState(savedInstanceState, persistentState)
        LogUtils.printLog(LifeCycleActivity.TAG,"onRestoreInstanceState() with persistentState")
    }

    override fun onTrimMemory(level: Int) {
        super.onTrimMemory(level)
        LogUtils.printLog(LifeCycleActivity.TAG,"onTrimMemory(${level})")
    }

    override fun onLowMemory() {
        super.onLowMemory()
        LogUtils.printLog(LifeCycleActivity.TAG,"onLowMemory()")
    }
}
