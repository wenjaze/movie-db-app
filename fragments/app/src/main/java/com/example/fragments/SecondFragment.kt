package com.example.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_second.view.*

class SecondFragment : Fragment() {

    companion object {
        fun newInstance() = SecondFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_second, container, false)
        val receivedData = arguments?.getStringArrayList("datas")
        rootView.movie_title.setText(receivedData!![0])
        rootView.movie_id.setText(receivedData!![1])
        rootView.movie_release_date.setText(receivedData!![2])
        rootView.movie_vote_average.setText(receivedData!![3])

        return rootView
    }
}
