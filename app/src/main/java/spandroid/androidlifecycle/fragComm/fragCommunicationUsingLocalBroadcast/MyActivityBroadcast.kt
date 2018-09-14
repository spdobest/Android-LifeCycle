package spandroid.androidlifecycle.fragComm.fragCommunicationUsingLocalBroadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v4.content.LocalBroadcastManager
import android.util.Log
import spandroid.androidlifecycle.R
import spandroid.androidlifecycle.activity.LifeCycleActivity
import spandroid.androidlifecycle.utility.LogUtils
import kotlinx.android.synthetic.main.activity_fragments.*
import spandroid.androidlifecycle.fragComm.MyFragmentsActivity
import spandroid.androidlifecycle.fragments.FragmentBroadcastB

class MyActivityBroadcast : AppCompatActivity() {

    companion object {
        val TAG = "MyActivityBroadcast"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragments)

        LogUtils.printLog(LifeCycleActivity.TAG, "OnCreate()")

        /**
         * REGISTER THE LOCAL BROADCAST TO RECIEVE THE EVENTS
         */

        // Register to receive messages.
        // We are registering an observer (mMessageReceiver) to receive Intents
        // with actions named "custom-event-name".
        LocalBroadcastManager.getInstance(this).registerReceiver(mMessageReceiver,
                IntentFilter("FragmentA-FragmentB"))
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
        LocalBroadcastManager.getInstance(this).unregisterReceiver(mMessageReceiver);
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
    /**
     * DECLARE THE LOCAL BROADCAST MANAGER CLASS HERE
     *
     */

    // Our handler for received Intents. This will be called whenever an Intent
    // with an action named "custom-event-name" is broadcasted.
    private val mMessageReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {
            // Get extra data included in the Intent
            val message = intent.getStringExtra("message")
            Log.d("receiver", "Got message: $message")

            supportFragmentManager.beginTransaction().
                    add(R.id.fragment_container,FragmentBroadcastB(), MyFragmentsActivity.TAG).commitAllowingStateLoss()

        }
    }

}
