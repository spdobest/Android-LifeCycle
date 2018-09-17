package spandroid.androidlifecycle.observerPattern

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.AppCompatButton
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import spandroid.androidlifecycle.R
import android.support.v7.widget.AppCompatEditText




private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class ObserverFragmentA : Fragment(),View.OnClickListener,Subject {

    private lateinit var observer:Observer

    override fun register(observer: Observer) {
        /*if (!observers.contains(observer)) {
            observers.add(observer)
        }*/
        this.observer = observer
    }

    override fun unregister(observer: Observer?) {

    }

    override fun notifyObservers(message: String) {
       /* for (observer in observers) {
            observer.update(message)
        }*/
        observer.update(message)    }

    override fun onClick(p0: View?) {
        when(p0?.id){
            R.id.buttonSendMessage ->{
                /**
                 * HERE WE WILL LOAD NEXT FRAGMENT USING LOCAL BROADCAST MANAGER
                  */
                notifyObservers(editTextMessage.text.toString().trim())
            }
        }
    }

    private var param1: String? = null
    private var param2: String? = null

    lateinit var buttonSendMessage: AppCompatButton
    lateinit var editTextMessage: AppCompatEditText


    override fun onAttach(context: Context) {
        super.onAttach(context)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_observera, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        buttonSendMessage = view.findViewById(R.id.buttonSendMessage)
        editTextMessage = view.findViewById(R.id.editTextMessage)
        buttonSendMessage.setOnClickListener(this)
    }
    companion object {
        val TAG: String = "ObserverFragmentA"
    }

}
