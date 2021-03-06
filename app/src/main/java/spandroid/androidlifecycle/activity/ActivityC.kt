package spandroid.androidlifecycle.activity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v4.app.Fragment
import android.view.View
import spandroid.androidlifecycle.R
import spandroid.androidlifecycle.utility.LogUtils
import kotlinx.android.synthetic.main.activity_c.*

class ActivityC  : AppCompatActivity(),View.OnClickListener{
    override fun onClick(view: View?) {
        when(view?.id){
            R.id.buttonA->{
                startActivity(Intent(this,ActivityA::class.java))
            }
        }
    }

    var strLifecycle:StringBuffer = StringBuffer()

    companion object {
        val TAG:String = "ActivityC"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_c)

        LogUtils.printLog(TAG,"OnCreate()")

        buttonA.setOnClickListener(this)

        strLifecycle.append("onCreate() ")
        textViewLifecycle.text = strLifecycle.toString()


    }

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        LogUtils.printLog(TAG,"OnCreate() with persistentState")
    }

    override fun onStart() {
        super.onStart()
        LogUtils.printLog(TAG,"onStart()")
        strLifecycle.append("onStart() ")
        textViewLifecycle.text = strLifecycle.toString()
    }

    override fun onResume() {
        super.onResume()
        LogUtils.printLog(TAG,"onResume()")
        strLifecycle.append("onResume() ")
        textViewLifecycle.text = strLifecycle.toString()
    }

    override fun onPause() {
        super.onPause()
        LogUtils.printLog(TAG,"onPause(0")
        strLifecycle.append("onPause() ")
        textViewLifecycle.text = strLifecycle.toString()
    }

    override fun onStop() {
        super.onStop()
        LogUtils.printLog(TAG,"onStop()")
        strLifecycle.append("onStop() ")
        textViewLifecycle.text = strLifecycle.toString()
    }

    override fun onRestart() {
        super.onRestart()
        LogUtils.printLog(TAG,"onRestart()")
        strLifecycle.append("onRestart() ")
        textViewLifecycle.text = strLifecycle.toString()
    }

    override fun onDestroy() {
        super.onDestroy()
        LogUtils.printLog(TAG,"onDestroy()")
        strLifecycle.append("onDestroy() ")
        textViewLifecycle.text = strLifecycle.toString()
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        LogUtils.printLog(TAG,"onSaveInstanceState()")
        strLifecycle.append("onSaveInstanceState() ")
        textViewLifecycle.text = strLifecycle.toString()
    }

    override fun onSaveInstanceState(outState: Bundle?, outPersistentState: PersistableBundle?) {
        super.onSaveInstanceState(outState, outPersistentState)
        LogUtils.printLog(TAG,"onSaveInstanceState() with outPersistentState")
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)
        LogUtils.printLog(TAG,"onRestoreInstanceState()")
        strLifecycle.append("onRestoreInstanceState() ")
        textViewLifecycle.text = strLifecycle.toString()
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
