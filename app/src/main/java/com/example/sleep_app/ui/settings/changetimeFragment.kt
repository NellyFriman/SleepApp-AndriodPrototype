package com.example.sleep_app.ui.settings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.ViewModelProvider
import com.example.sleep_app.R


class changetimeFragment : Fragment() {

    companion object {
        fun newInstance() = changetimeFragment()
    }

    private lateinit var viewModel: changetime_model

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        viewModel = ViewModelProvider(this).get(changetime_model::class.java)
        var root= inflater.inflate(R.layout.fragment_changetime, container, false)

        val buttChangeTimeEnds: Button = root.findViewById(R.id.buttonChangeTimeEnds)
        buttChangeTimeEnds.setOnClickListener {
            val clocK: Fragment = clock()
            val transaction: FragmentTransaction = requireFragmentManager().beginTransaction()
            transaction.replace(R.id.nav_host_fragment,clocK)
            transaction.addToBackStack(null);
            transaction.commit();

        }
        val buttChangeTimeDays: Button = root.findViewById(R.id.buttonChangeTimeDays)
        buttChangeTimeDays.setOnClickListener {
            val clocK: Fragment = clock()
            val transaction: FragmentTransaction = requireFragmentManager().beginTransaction()
            transaction.replace(R.id.nav_host_fragment,clocK)
            transaction.addToBackStack(null);
            transaction.commit();

        }
        val buttConfirm: Button = root.findViewById(R.id.buttonConfirm2)
        buttConfirm.setOnClickListener {
            val settings: Fragment = SettingsFragment()
            val transaction: FragmentTransaction = requireFragmentManager().beginTransaction()
            transaction.replace(R.id.nav_host_fragment,settings)
            transaction.addToBackStack(null);
            transaction.commit();

        }
        return root
    }



}