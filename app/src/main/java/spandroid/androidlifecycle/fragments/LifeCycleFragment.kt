package spandroid.androidlifecycle.fragments

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.AppCompatTextView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.activity_life_cycle.*

import spandroid.androidlifecycle.R
import spandroid.androidlifecycle.activity.LifeCycleActivity
import spandroid.androidlifecycle.utility.LogUtils

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class LifeCycleFragment : Fragment() {
    private var param1: String? = null
    private var param2: String? = null
    private var listener: OnFragmentInteractionListener? = null

    lateinit var textViewFragmentLifecycle: AppCompatTextView
    var strLifecycle: StringBuffer = StringBuffer()


    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnFragmentInteractionListener")
        }

        LogUtils.printLog(TAG, "onAttach()")

        strLifecycle.append("onAttach(Fragment)")

        (LifeCycleActivity()).showLifecycleMethods("onAttach()")

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
        LogUtils.printLog(TAG, "onCreate()")
        strLifecycle.append("onCreate() ")
        (LifeCycleActivity()).showLifecycleMethods("onCreate(Fragment)")
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        LogUtils.printLog(TAG, "onCreateView()")
        (LifeCycleActivity()).showLifecycleMethods("onCreateView(Fragment)")
        return inflater.inflate(R.layout.fragment_life_cycle, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        LogUtils.printLog(TAG, "onViewCreated()")
        textViewFragmentLifecycle = view.findViewById(R.id.textViewFragmentLifecycle)
        strLifecycle.append("onViewCreated() ")
        textViewFragmentLifecycle.text = strLifecycle.toString()

        (LifeCycleActivity()).showLifecycleMethods("onViewCreated(Fragment)")

    }

    override fun onStart() {
        super.onStart()
        LogUtils.printLog(TAG, "onStart()")
        strLifecycle.append("onStart() ")
        textViewFragmentLifecycle.text = strLifecycle.toString()

        (LifeCycleActivity()).showLifecycleMethods("onStart(Fragment)")
    }

    override fun onResume() {
        super.onResume()
        LogUtils.printLog(TAG, "onResume()")
        strLifecycle.append("onResume() ")
        textViewFragmentLifecycle.text = strLifecycle.toString()

        (LifeCycleActivity()).showLifecycleMethods("onResume(Fragment)")
    }

    override fun onPause() {
        super.onPause()
        LogUtils.printLog(TAG, "onPause()")
        strLifecycle.append("onPause() ")
        (LifeCycleActivity()).showLifecycleMethods("onPause(Fragment)")
    }

    override fun onStop() {
        super.onStop()
        LogUtils.printLog(TAG, "onStop()")
        strLifecycle.append("onStop() ")
        (LifeCycleActivity()).showLifecycleMethods("onStop(Fragment)")
    }

    override fun onDestroy() {
        super.onDestroy()
        LogUtils.printLog(TAG, "onDestroy()")
        strLifecycle.append("onDestroy() ")
        (LifeCycleActivity()).showLifecycleMethods("onDestroy(Fragment)")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        LogUtils.printLog(TAG, "onDestroyView()")
        strLifecycle.append("onDestroyView() ")
        (LifeCycleActivity()).showLifecycleMethods("onDestroyView(Fragment)")
    }


    override fun onDetach() {
        super.onDetach()
        listener = null
        LogUtils.printLog(TAG, "onDetach()")
        strLifecycle.append("onDetach() ")
        (LifeCycleActivity()).showLifecycleMethods("onDetach(Fragment)")
    }

    override fun onLowMemory() {
        super.onLowMemory()
        LogUtils.printLog(TAG, "onLowMemory()")
        strLifecycle.append("onLowMemory() ")
    }


    /*fun onButtonPressed(uri: Uri) {
        listener?.onFragmentInteraction(uri)
    }*/
    interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        fun onFragmentInteraction(uri: Uri)
    }

    companion object {

        val TAG: String = "LifeCycleFragment"
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
                LifeCycleFragment().apply {
                    arguments = Bundle().apply {
                        putString(ARG_PARAM1, param1)
                        putString(ARG_PARAM2, param2)
                    }
                }
    }
}
