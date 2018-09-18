package spandroid.androidlifecycle.observerPattern

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v4.app.Fragment
import android.view.View
import spandroid.androidlifecycle.R
import spandroid.androidlifecycle.oreoBadges.OreoNotificationHelper
import spandroid.androidlifecycle.utility.LogUtils

class ObserverActivity  : AppCompatActivity(),View.OnClickListener {

    companion object {
        val TAG:String = "ObserverActivity"
    }

    override fun onClick(view: View?) {
        when(view?.id){

        }
    }

    var strLifecycle:StringBuffer = StringBuffer()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_observer)

        LogUtils.printLog(TAG,"OnCreate()")

        strLifecycle.append("onCreate() ")

        val fragmentA:ObserverFragmentA = ObserverFragmentA()
        val fragmentB:ObserverFragmentB = ObserverFragmentB()

        val oreoNotificationHelper = OreoNotificationHelper(this)
        oreoNotificationHelper.postOreoNotification(this,123,"SIba","satya")



        supportFragmentManager.beginTransaction().replace(R.id.fragment_container1,fragmentA,"A").commitAllowingStateLoss()
        supportFragmentManager.beginTransaction().replace(R.id.fragment_container2,fragmentB,"B").commitAllowingStateLoss()


        fragmentA.register(fragmentB)

    }

    override fun onStart() {
        super.onStart()
        LogUtils.printLog(TAG,"onStart()")
        strLifecycle.append("onStart() ")
    }

    override fun onResume() {
        super.onResume()
        LogUtils.printLog(TAG,"onResume()")
        strLifecycle.append("onResume() ")
    }

    override fun onPause() {
        super.onPause()
        LogUtils.printLog(TAG,"onPause(0")
        strLifecycle.append("onPause() ")
    }

    override fun onStop() {
        super.onStop()
        LogUtils.printLog(TAG,"onStop()")
        strLifecycle.append("onStop() ")
    }

    override fun onRestart() {
        super.onRestart()
        LogUtils.printLog(TAG,"onRestart()")
        strLifecycle.append("onRestart() ")
    }

    override fun onDestroy() {
        super.onDestroy()
        LogUtils.printLog(TAG,"onDestroy()")
        strLifecycle.append("onDestroy() ")
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        LogUtils.printLog(TAG,"onSaveInstanceState()")
        strLifecycle.append("onSaveInstanceState() ")
    }

    override fun onSaveInstanceState(outState: Bundle?, outPersistentState: PersistableBundle?) {
        super.onSaveInstanceState(outState, outPersistentState)
        LogUtils.printLog(TAG,"onSaveInstanceState() with outPersistentState")
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)
        LogUtils.printLog(TAG,"onRestoreInstanceState()")
        strLifecycle.append("onRestoreInstanceState() ")
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onRestoreInstanceState(savedInstanceState, persistentState)
        LogUtils.printLog(TAG,"onRestoreInstanceState() with persistentState")
    }

    override fun onTrimMemory(level: Int) {
        super.onTrimMemory(level)
        LogUtils.printLog(TAG,"onTrimMemory(${level})")
    }

    override fun onLowMemory() {
        super.onLowMemory()
        LogUtils.printLog(TAG,"onLowMemory()")
    }

    override fun onAttachFragment(fragment: Fragment?) {
        super.onAttachFragment(fragment)
        LogUtils.printLog(TAG,"onAttachFragment()")
        strLifecycle.append("onAttachFragment() ")
    }
}
