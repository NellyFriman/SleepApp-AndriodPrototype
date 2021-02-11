package com.example.sleep_app.ui.home

import android.content.Intent
import android.os.Bundle
import android.transition.*
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.sleep_app.Questionnaire
import com.example.sleep_app.R


class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        homeViewModel =
                ViewModelProvider(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        val textView: TextView = root.findViewById(R.id.text_home)
        homeViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        val cardView: CardView = root.findViewById(R.id.card1)
        val cardLayout: RelativeLayout = root.findViewById(R.id.cardLayout1)
        cardLayout.setOnClickListener {
            val intent = Intent(context, Questionnaire::class.java);
            startActivity(intent);
        }

        return root
    }


}