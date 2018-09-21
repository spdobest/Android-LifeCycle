package spandroid.androidlifecycle.backStack

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.AppCompatButton
import android.support.v7.widget.AppCompatCheckBox
import android.support.v7.widget.AppCompatEditText
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import spandroid.androidlifecycle.R
import spandroid.androidlifecycle.fragments.FragmentBroadcastA
import spandroid.androidlifecycle.fragments.FragmentBroadcastB

class BackStackFragmentA : BaseFragment() {

    lateinit var editTextName: AppCompatEditText
    lateinit var editTextEmail: AppCompatEditText
    lateinit var editTextMobile: AppCompatEditText
    lateinit var checkBox: AppCompatCheckBox
    lateinit var buttonStartNext: AppCompatButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = if (view != null) view else inflater.inflate(R.layout.fragment_back_stack_a, container, false)
        return view// inflater.inflate(R.layout.fragment_back_stack_a, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        editTextName = view.findViewById(R.id.editTextName)
        editTextEmail = view.findViewById(R.id.editTextEmail)
        editTextMobile = view.findViewById(R.id.editTextMobile)
        checkBox = view.findViewById(R.id.checkBox)
        buttonStartNext = view.findViewById(R.id.buttonStartNext)

        buttonStartNext.setOnClickListener {
            addFragment(BackStackFragmentB())
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
       /* if (context is OnFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnFragmentInteractionListener")
        }*/
    }

    override fun onDetach() {
        super.onDetach()
      //  listener = null
    }
    companion object {
        val TAG = BackStackFragmentA.javaClass.name
    }
}
