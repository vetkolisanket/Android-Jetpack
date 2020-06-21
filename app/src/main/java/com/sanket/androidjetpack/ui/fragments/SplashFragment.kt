package com.sanket.androidjetpack.ui.fragments

import android.os.Bundle
import android.os.Handler
import android.preference.PreferenceManager
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.navigation.fragment.findNavController
import com.sanket.androidjetpack.R
import com.sanket.androidjetpack.isUserLoggedIn
import com.sanket.androidjetpack.ui.activities.MainActivity

/**
 * A simple [Fragment] subclass.
 * Use the [SplashFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SplashFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }

        val backPressCallback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                // do nothing
            }
        }

        requireActivity().onBackPressedDispatcher.addCallback(this, backPressCallback)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_splash, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Handler().postDelayed({ redirectToAppropriateFragment() }, 2000)
    }

    private fun redirectToAppropriateFragment() {
        if (isUserLoggedIn()) {
            findNavController().navigate(R.id.homeFragment)
        } else {
             findNavController().navigate(R.id.loginFragment)
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @return A new instance of fragment SplashFragment.
         */
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            SplashFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }
}
