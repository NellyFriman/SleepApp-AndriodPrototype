package com.example.sleep_app.ui.settings

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.FragmentTransaction
import com.example.sleep_app.R

class clock : Fragment() {

    companion object {
        fun newInstance() = clock()
    }

    private lateinit var viewModel: ClockViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        viewModel = ViewModelProvider(this).get(ClockViewModel::class.java)
        val root=  inflater.inflate(R.layout.clock_fragment, container, false)

        val buttConfirm: Button = root.findViewById(R.id.buttonConfirm)
        buttConfirm.setOnClickListener {
            val changetime: Fragment = changetimeFragment()
            val transaction: FragmentTransaction = requireFragmentManager().beginTransaction()
            transaction.replace(R.id.nav_host_fragment,changetime)
            transaction.addToBackStack(null);
            transaction.commit();

        }
        return root

    }



}