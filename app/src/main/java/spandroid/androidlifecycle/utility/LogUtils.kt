package spandroid.androidlifecycle.utility

import android.util.Log

class LogUtils{

    companion object {
        fun printLog( tag:String = "TAG",message:String){
            Log.i(tag, "message : "+message)
        }
    }

}