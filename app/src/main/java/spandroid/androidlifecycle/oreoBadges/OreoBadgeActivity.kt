package spandroid.androidlifecycle.oreoBadges

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import spandroid.androidlifecycle.R

class OreoBadgeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_oreo_badge)

        val oreoNotificationHelper = OreoNotificationHelper(this)
        oreoNotificationHelper.createNotificationChannels()


    }
}
