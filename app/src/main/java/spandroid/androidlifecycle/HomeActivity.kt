package spandroid.androidlifecycle

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle

import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.activity_life_cycle.*
import spandroid.androidlifecycle.activity.LifeCycleActivity

//import kotlinx.android.synthetic.main.note_priorities_chooser_view.*

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val intent:Intent = Intent(this,LifeCycleActivity::class.java)
        startActivity(intent)

    }
}
