package com.example.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import kotlinx.android.synthetic.main.item_movie.*
import kotlinx.android.synthetic.main.item_movie.view.*

class SecondFragment : Fragment() {
    var movieTitle : String? = ""
    companion object {
        fun newInstance() = SecondFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ) : View? {
        val rootView = inflater.inflate(R.layout.fragment_second, container, false)
        movieTitle = arguments?.getString("movieTitle")
        rootView.movie_title.text = movieTitle
        return rootView
    }

    /*override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }*/

    /*override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val button = getView()?.findViewById(R.id.switch_button) as Button
        button.setOnClickListener(){
            val firstFragment = FirstFragment()
            switchToFirstFragment(firstFragment)
        }
    }

    private fun switchToFirstFragment(fragment: Fragment) {
        val transaction = activity?.supportFragmentManager?.beginTransaction()
        transaction?.replace(R.id.frameLayout,fragment)
        transaction?.addToBackStack(null)
        transaction?.commit()

    }*/
}
