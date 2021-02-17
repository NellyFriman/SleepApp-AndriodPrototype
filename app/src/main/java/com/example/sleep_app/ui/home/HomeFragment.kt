package com.example.sleep_app.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.ViewModelProvider
import com.example.sleep_app.Questionnaire
import com.example.sleep_app.R
import com.example.sleep_app.ui.settings.changetimeFragment


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
        /*val textView: TextView = root.findViewById(R.id.text_home)
        homeViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })*/
        val cardView: CardView = root.findViewById(R.id.card2)
        val cardLayout2: RelativeLayout = root.findViewById(R.id.cardLayout2)
        cardLayout2.setOnClickListener {
            val intent = Intent(context, Questionnaire::class.java);
            startActivity(intent);
        }
        val cardLayout1: RelativeLayout = root.findViewById(R.id.cardLayout1)
        cardLayout1.setOnClickListener {
            val startTest: Fragment = StartTest()
            val transaction: FragmentTransaction = requireFragmentManager().beginTransaction()
            transaction.setCustomAnimations(R.anim.fade_in, R.anim.fade_out)
            transaction.replace(R.id.nav_host_fragment,startTest)
            transaction.addToBackStack(null);
            transaction.commit();
        }

        return root
    }


}