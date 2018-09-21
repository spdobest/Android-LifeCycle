package spandroid.androidlifecycle.backStack

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import spandroid.androidlifecycle.R

class BackStackActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_back_stack)

        supportFragmentManager
                ?.beginTransaction()!!
                .add(R.id.fragment_container,BackStackFragmentA(),"BackStackFragmentA")
                .addToBackStack("BackStackFragmentA")
                .commitAllowingStateLoss()



    }
}