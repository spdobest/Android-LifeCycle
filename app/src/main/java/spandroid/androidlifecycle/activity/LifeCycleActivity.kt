package spandroid.androidlifecycle.activity

import android.app.Fragment
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import spandroid.androidlifecycle.R
import spandroid.androidlifecycle.utility.LogUtils
import kotlinx.android.synthetic.main.activity_life_cycle.*
import spandroid.androidlifecycle.fragments.LifeCycleFragment

class LifeCycleActivity : AppCompatActivity(), 
        LifeCycleFragment.OnFragmentInteractionListener, LifeCycleFragment.OnPrintListener {
   

    override fun onFragmentInteraction(uri: Uri) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    var strLifecycle:StringBuffer = StringBuffer()

    companion object {
        val TAG:String = "LifeCycleActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_life_cycle)

        LogUtils.printLog(TAG,"OnCreate()")

        strLifecycle.append("onCreate() ")
//        textViewLifecycle.text = strLifecycle.toString()

        onPrint()
        supportFragmentManager.beginTransaction().add(R.id.fragment_container,LifeCycleFragment(), TAG).commit()

    }

    override fun onStart() {
        super.onStart()
        LogUtils.printLog(TAG,"onStart()")
        strLifecycle.append("onStart() ")
//        textViewLifecycle.text = strLifecycle.toString()
        onPrint()
    }

    override fun onResume() {
        super.onResume()
        LogUtils.printLog(TAG,"onResume()")
        strLifecycle.append("onResume() ")
        //        textViewLifecycle.text = strLifecycle.toString()
        onPrint()
    }

    override fun onPause() {
        super.onPause()
        LogUtils.printLog(TAG,"onPause(0")
        strLifecycle.append("onPause() ")
        //        textViewLifecycle.text = strLifecycle.toString()
        onPrint()
    }

    override fun onStop() {
        super.onStop()
        LogUtils.printLog(TAG,"onStop()")
        strLifecycle.append("onStop() ")
        //        textViewLifecycle.text = strLifecycle.toString()
        onPrint()
    }

    override fun onRestart() {
        super.onRestart()
        LogUtils.printLog(TAG,"onRestart()")
        strLifecycle.append("onRestart() ")
        //        textViewLifecycle.text = strLifecycle.toString()
        onPrint()
    }

    override fun onDestroy() {
        super.onDestroy()
        LogUtils.printLog(TAG,"onDestroy()")
        strLifecycle.append("onDestroy() ")
        //        textViewLifecycle.text = strLifecycle.toString()
        onPrint()
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        LogUtils.printLog(TAG,"onSaveInstanceState()")
        strLifecycle.append("onSaveInstanceState() ")
        //        textViewLifecycle.text = strLifecycle.toString()
        onPrint()
    }

    override fun onSaveInstanceState(outState: Bundle?, outPersistentState: PersistableBundle?) {
        super.onSaveInstanceState(outState, outPersistentState)
        LogUtils.printLog(TAG,"onSaveInstanceState() with outPersistentState")
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)
        LogUtils.printLog(TAG,"onRestoreInstanceState()")
        strLifecycle.append("onRestoreInstanceState() ")
        //        textViewLifecycle.text = strLifecycle.toString()
        onPrint()
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
     
    override fun onPrint(message: String) {
        strLifecycle.append(message)
        textViewLifecycle.text = strLifecycle.toString()
    }
}
