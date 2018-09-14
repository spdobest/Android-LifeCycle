package spandroid.androidlifecycle.fragComm.fragment_communicationusing_observer


import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.AppCompatButton
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import spandroid.androidlifecycle.R
import spandroid.androidlifecycle.utility.LogUtils


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class ObserverFragmentB : Fragment(), View.OnClickListener {
    override fun onClick(p0: View?) {
        when(p0?.id){
            R.id.buttonStartNextFragment ->{
                /**
                 * HERE WE WILL LOAD NEXT FRAGMENT USING LOCAL BROADCAST MANAGER
                 */

            }
        }
    }

    private var param1: String? = null
    private var param2: String? = null
    private var listener: OnFragmentInteractionListener? = null

    lateinit var buttonStartNextFragment: AppCompatButton


    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnFragmentInteractionListener")
        }

        LogUtils.printLog(TAG, "onAttach()")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        /* arguments?.let {
             param1 = it.getString(ARG_PARAM1)
             param2 = it.getString(ARG_PARAM2)
         }*/
        LogUtils.printLog(TAG, "onCreate()")
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        LogUtils.printLog(TAG, "onCreateView()")
        return inflater.inflate(R.layout.fragment_broadcasta, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        LogUtils.printLog(TAG, "onViewCreated()")

        buttonStartNextFragment = view.findViewById(R.id.buttonStartNextFragment)
        buttonStartNextFragment.setOnClickListener(this)
    }

    override fun onStart() {
        super.onStart()
        LogUtils.printLog(TAG, "onStart()")
    }

    override fun onResume() {
        super.onResume()
        LogUtils.printLog(TAG, "onResume()")
    }

    override fun onPause() {
        super.onPause()
        LogUtils.printLog(TAG, "onPause()")
    }

    override fun onStop() {
        super.onStop()
        LogUtils.printLog(TAG, "onStop()")
    }

    override fun onDestroy() {
        super.onDestroy()
        LogUtils.printLog(TAG, "onDestroy()")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        LogUtils.printLog(TAG, "onDestroyView()")
    }


    override fun onDetach() {
        super.onDetach()
        listener = null
        LogUtils.printLog(TAG, "onDetach()")
    }

    override fun onLowMemory() {
        super.onLowMemory()
        LogUtils.printLog(TAG, "onLowMemory()")
    }


    /*fun onButtonPressed(uri: Uri) {
        listener?.onFragmentInteraction(uri)
    }*/
    interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        fun onFragmentInteraction(uri: Uri)
    }

    companion object {
        val TAG: String = "ObserverFragmentB"
    }
}
