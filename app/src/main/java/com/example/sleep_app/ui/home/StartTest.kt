package com.example.sleep_app.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RelativeLayout
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.ViewModelProvider
import com.example.sleep_app.Encoding
import com.example.sleep_app.Questionnaire
import com.example.sleep_app.R
import com.example.sleep_app.ui.home.HomeViewModel
import com.example.sleep_app.ui.home.StartTestViewModel
import com.example.sleep_app.ui.settings.changetimeFragment

class StartTest : Fragment() {

    private lateinit var startTestViewModel: StartTestViewModel


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        startTestViewModel =
            ViewModelProvider(this).get(StartTestViewModel::class.java)
        val root = inflater.inflate(R.layout.start_test_fragment, container, false)
        val startTestButton: Button = root.findViewById(R.id.testStartButton)
        startTestButton.setOnClickListener {
            val intent = Intent(context, Encoding::class.java);
            startActivity(intent);

        }


        return root
    }


}