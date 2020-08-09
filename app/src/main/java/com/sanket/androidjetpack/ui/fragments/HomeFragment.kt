package com.sanket.androidjetpack.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.sanket.androidjetpack.R
import com.sanket.androidjetpack.hide
import com.sanket.androidjetpack.models.daos.Answer
import com.sanket.androidjetpack.network.ApiHelper
import com.sanket.androidjetpack.network.RetrofitBuilder
import com.sanket.androidjetpack.show
import com.sanket.androidjetpack.ui.adapters.MainAdapter
import com.sanket.androidjetpack.utils.Status.*
import com.sanket.androidjetpack.view_models.HomeViewModel
import com.sanket.androidjetpack.view_models.ViewModelFactory
import kotlinx.android.synthetic.main.fragment_home.*

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {

    private val viewModel by lazy {
        ViewModelProviders.of(
            this, ViewModelFactory(
                ApiHelper(
                    RetrofitBuilder.apiService
                )
            )
        ).get(HomeViewModel::class.java)
    }
    private val adapter by lazy { MainAdapter(mutableListOf()) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }

        val backPressCallback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                requireActivity().finish()
            }
        }

        requireActivity().onBackPressedDispatcher.addCallback(this, backPressCallback)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUi()
        initObservers()
    }

    private fun initObservers() {
        viewModel.getUsers().observe(viewLifecycleOwner, Observer {
            it?.let { resource ->
                when (resource.status) {
                    SUCCESS -> {
                        recyclerView.show()
                        progressBar.hide()
                        resource.data?.let { answers -> retrieveList(answers) }
                    }
                    ERROR -> {
                        recyclerView.show()
                        progressBar.hide()
                        Toast.makeText(requireContext(), it.message, Toast.LENGTH_LONG).show();
                    }
                    LOADING -> {
                        recyclerView.hide()
                        progressBar.show()
                    }
                }
            }
        })
    }

    private fun initUi() {
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.addItemDecoration(DividerItemDecoration(requireContext(), (recyclerView.layoutManager as LinearLayoutManager).orientation))
        recyclerView.adapter = adapter
    }

    private fun retrieveList(answers: List<Answer>) {
        adapter.apply {
            addAnswers(answers)
            notifyDataSetChanged()
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @return A new instance of fragment HomeFragment.
         */
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomeFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }
}
