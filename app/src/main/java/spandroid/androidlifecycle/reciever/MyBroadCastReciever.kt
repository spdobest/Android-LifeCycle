package spandroid.androidlifecycle.reciever

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.IBinder
import spandroid.androidlifecycle.utility.LogUtils

class MyBroadCastReciever:BroadcastReceiver(){
    override fun peekService(myContext: Context?, service: Intent?): IBinder {
        return super.peekService(myContext, service)
    }

    companion object {
        val TAG = "MyBroadCastReciever"
    }

    override fun onReceive(p0: Context?, p1: Intent?) {
        LogUtils.printLog(TAG,"onReceive")
    }

}