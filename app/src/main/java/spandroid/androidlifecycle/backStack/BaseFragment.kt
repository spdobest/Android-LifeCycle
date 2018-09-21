package spandroid.androidlifecycle.backStack


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import spandroid.androidlifecycle.R
import android.R.attr.fragment
import android.R.attr.fragment





/**
 * A simple [Fragment] subclass.
 *
 */
open abstract class BaseFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_base, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }


    public fun addFragment(fragment:Fragment){

        val backStateName = fragment.javaClass.name

        val manager = activity?.supportFragmentManager
        val fragmentPopped:Boolean? = manager?.popBackStackImmediate(backStateName, 0)

        if (fragmentPopped == true) {
            activity?.supportFragmentManager
                    ?.beginTransaction()!!
                    .add(R.id.fragment_container,fragment,fragment.tag)
                    .addToBackStack(fragment.tag)
                    .commitAllowingStateLoss()
        }
        else{
            //fragment not in back stack, create it.
            val ft = manager?.beginTransaction()
            ft?.replace(R.id.fragment_container, fragment)
            ft?.addToBackStack(backStateName)
            ft?.commitAllowingStateLoss()
        }


    }

    public fun replaceFragment(fragment:Fragment){
        activity?.supportFragmentManager
                ?.beginTransaction()!!
                .replace(R.id.fragment_container,fragment,fragment.tag)
                .commitAllowingStateLoss()
    }
}
