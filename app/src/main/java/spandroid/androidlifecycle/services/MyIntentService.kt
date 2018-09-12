package spandroid.androidlifecycle.services

import android.app.IntentService
import android.content.Intent
import android.os.IBinder

class MyIntentService:IntentService("MyIntentService"){
    override fun onHandleIntent(intent: Intent?) {

    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onCreate() {
        super.onCreate()
    }

    override fun onStart(intent: Intent?, startId: Int) {
        super.onStart(intent, startId)
    }

    override fun onBind(intent: Intent?): IBinder {
        return super.onBind(intent)
    }

    override fun setIntentRedelivery(enabled: Boolean) {
        super.setIntentRedelivery(enabled)
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}