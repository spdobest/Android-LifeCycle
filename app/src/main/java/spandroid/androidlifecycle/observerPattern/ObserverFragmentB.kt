package spandroid.androidlifecycle.observerPattern

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.AppCompatTextView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import spandroid.androidlifecycle.R

class ObserverFragmentB : Fragment(),View.OnClickListener,Observer {

    override fun update(message: String) {
        if(isVisible){
            textViewMessage.text = message
        }
    }

    override fun onClick(p0: View?) {
        when (p0?.id) {

        }
    }

    lateinit var textViewMessage: AppCompatTextView


    override fun onAttach(context: Context) {
        super.onAttach(context)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_observerb, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        textViewMessage = view.findViewById(R.id.textViewMessage)
    }

    companion object {
        val TAG: String = "ObserverFragmentB"
    }
}